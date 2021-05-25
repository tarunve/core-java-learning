package com.java.enhancements.E004.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 *  HttpClient:
 *  -   Replacement for java.net.HTTPURLConnection.
 *  -   Supports HTTP/2, Websocket natively.
 *  -   incubator module in java9 : module is not final i.e. can be
 *      modified in next releases.
 *
 *  HTTP/1 vs HTTP/2
 *  -   Same :
 *      -   Request/Response based.
 *      -   GET/POST/PUT/etc. methods.
 *  -   Differences:
 *      -   Binary protocol.
 *      -   Mandatory TLS.
 *      -   Multiplexing over single TCP connection.
 *      -   Server push capabilities.
 */
public class E002_HttpClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        syncHttpCall();
        asyncHttpCall();
    }

    private static void syncHttpCall() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.pluralsight.com"))
                                        .GET()
                                        .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 200)
            System.out.println(response.headers().map());
    }

    private static void asyncHttpCall() {
        HttpClient.Builder builder = HttpClient.newBuilder();
        builder.version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS);

        HttpClient client = builder.build();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .header("User-Agent", "Java")
                .timeout(Duration.ofMillis(500))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        response.thenAccept(r -> {
            System.out.println("Version: " + r.version());
            System.out.println(r.body());
        });

        response.join();
    }
}
