package enhancements;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  -   Java had HttpURLConnection class for long time for HTTP communication. But over the time,
 *      requirements have gone complex and more demanding in applications. Before Java 11,
 *      developers had to resort to feature-rich libraries like Apache HttpComponents or OkHttp etc.
 *  -   We saw Java 9 release to include an HttpClient implementation as an experimental feature.
 *      It has grown over time and now a final feature of Java 11. Now the Java applications can
 *      make HTTP communications without the need to any external dependency.
 *  -   How to use HttpClient
 *          -   A typical HTTP interaction with the java.net.http module looks like-
 *              -   Create an instance of HttpClient and configure it as needed.
 *              -   Create an instance of HttpRequest and populate the information.
 *              -   Pass the request to the client, perform the request, and retrieve an instance of
 *                  HttpResponse.
 *              -   Process the information contained in the HttpResponse.
 */
public class E_001_HTTPClient {

    public static void syncRequest(){
        HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpRequest request;
        HttpResponse<String> response;
        try {
            String urlEndpoint = "https://postman-echo.com/get";
            URI uri = URI.create(urlEndpoint + "?foo1=bar1&foo2=bar2");
            request = HttpRequest.newBuilder().uri(uri).build();
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Headers: " + response.headers().allValues("content-type"));
        System.out.println("Body: " + response.body());
    }

    public static void asyncRequest(){
        final List<URI> uris = Stream.of("https://www.google.com/", "https://www.github.com/")
                    .map(URI::create).collect(Collectors.toList());

        HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
                                    .followRedirects(HttpClient.Redirect.ALWAYS).build();

        CompletableFuture[] futures = uris.stream().map(uri -> verifyUri(httpClient, uri))
                                            .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
    }

    private static CompletableFuture<Void> verifyUri(HttpClient httpClient, URI uri) {
        HttpRequest request = HttpRequest.newBuilder().timeout(Duration.ofSeconds(5)).uri(uri).build();
        return httpClient.sendAsync(request,HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenApply(statusCode -> statusCode == 200)
                .exceptionally(ex -> false)
                .thenAccept(valid -> {
                    if (valid) {
                        System.out.println("[SUCCESS] Verified " + uri);
                    } else {
                        System.out.println("[FAILURE] Could not " + "verify " + uri);
                    }
                });
    }

    public static void main(String[] args) {
        syncRequest();
        System.out.println("==============================");
        asyncRequest();
    }
}
