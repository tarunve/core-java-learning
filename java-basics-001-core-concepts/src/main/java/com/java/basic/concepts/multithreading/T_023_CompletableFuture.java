package com.java.basic.concepts.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  -   The CompletableFuture class implements the Future Interface, so you can use it as a Future
 *      implementation, but with additional completion logic.
 *  -   You can create a instance of the class with no-arg constructor to represent some future result,
 *      hand it out to the consumers and complete it at some time in the future using the complete method.
 *      The consumers may use the get method to block the current thread until this result will be provided.
 *
 *  -   Static methods runAsync and supplyAsync allow us to create a CompletableFuture instance out of
 *      Runnable and Supplier functional types accordingly.
 *  -   Both Runnable & Supplier are functional interface. Runnable interface is same old interface that is
 *      used in threads and it does not allow to return a value. Supplier interface is a generic functional
 *      interface with a single method that has no arguments and returns a value of a parameterized type.
 *  -   Supplier allows to provide an instance of the Supplier as a lambda expression that does the
 *      calculation and returns the result.
 *
 */
public class T_023_CompletableFuture {

    private static CompletableFuture<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        List<String> list = new ArrayList<>();
        list.add("KK");
        list.add("SK");
        list.add("PK");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                System.out.println("Current Thread : " + Thread.currentThread().getName());
                Thread.sleep(20);
                String joinedStr = String.join(",", list);
                completableFuture.complete(joinedStr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return completableFuture;
        });
        return completableFuture;
    }

    private static void runAsyncMethod() throws InterruptedException {
        CompletableFuture.runAsync(() -> {
            System.out.println("Running task in runAsync Method.");
        });

        CompletableFuture.runAsync(() -> {
            System.out.println("Running task in runAsync Method with executor.");
        }, Executors.newSingleThreadExecutor());
        Thread.sleep(1000);
    }

    private static void supplyAsyncMethod() throws ExecutionException, InterruptedException {
        CompletableFuture<String> res = CompletableFuture.supplyAsync(() -> "Running task in supplyAsync Method.");
        System.out.println(res.get());

        CompletableFuture<String> res2 = CompletableFuture.supplyAsync(() -> "Running task in supplyAsync Method with executor."
                , Executors.newSingleThreadExecutor());
        System.out.println(res2);
        Thread.sleep(1000);
    }

    private static void thenAcceptMethod() throws ExecutionException, InterruptedException {
        CompletableFuture<String> res = CompletableFuture.supplyAsync(() -> "Hello");
        res.thenAccept(s -> System.out.println(s + " World"));
    }

    private static void thenApplyMethod() throws ExecutionException, InterruptedException {
        CompletableFuture<String> res = CompletableFuture.supplyAsync(() -> "Hello");
        res = res.thenApply(s -> s + " World");
        System.out.println(res.get());
    }

    private static void multipleFutureMethod() throws ExecutionException, InterruptedException {
        CompletableFuture<String> india = CompletableFuture.supplyAsync(() -> "India");
        CompletableFuture<String> usa = CompletableFuture.supplyAsync(() -> "is");
        CompletableFuture<String> uk = CompletableFuture.supplyAsync(() -> "beautiful");
        CompletableFuture<String> uae = CompletableFuture.supplyAsync(() -> "country");

        CompletableFuture<Void> countries = CompletableFuture.allOf(india, usa, uk, uae);
        System.out.println(countries.get());
        System.out.println(india.isDone());
        System.out.println(usa.isDone());
        System.out.println(uk.isDone());
        System.out.println(uae.isDone());

        String result = Stream.of(india, usa, uk, uae)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static void exceptionHandling() throws ExecutionException, InterruptedException {
        String name = null;
        CompletableFuture<String> res = CompletableFuture.supplyAsync(() -> {
            if(name == null) {
                throw new RuntimeException("Name is null.");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!!");
        System.out.println(res.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = calculateAsync();
        try{
            String res = result.get();
            System.out.println("Current Thread : " + Thread.currentThread().getName());
            System.out.println(res);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            result.complete("Completed the async Computation.");
        }
        System.out.println("=======================");

        // RunAsync
        runAsyncMethod();
        System.out.println("=======================");

        //supplyAsync
        supplyAsyncMethod();
        System.out.println("=======================");

        // thenAccept
        thenAcceptMethod();
        System.out.println("=======================");

        // thenApply
        thenApplyMethod();
        System.out.println("=======================");

        // multiple future runs
        multipleFutureMethod();
        System.out.println("=======================");

        // Exception Handling
        exceptionHandling();
        System.out.println("=======================");
    }
}
