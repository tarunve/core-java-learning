package com.java.enhancements;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  Fork Join Framework:
 *  -   Fork : dividing the tasks into similar sub tasks.
 *      Join : merge/combine the result of sub tasks into final output.
 *  -   In Java 8, ForkJoinPool is created when JVM is started. So, system uses the
 *      same pool for all the parallel computations. And by default, it is created
 *      with the number of cores in system (virtual cores)
 *  -   Works on work stealing algorithm i.e. if any thread is ideal , it will try
 *      to pull tasks from other thread and joining will happen later.
 *  -   We can customize the parallelism using system property:
 *          java.util.concurrent.ForkJoinPool.common.parallelism
 *
 *  Where parallel stream can go wrong :
 *  1.  Hidden Synchronization
 *      - Example : limit() functions reduce the performance by half when computed parallely.
 *  2.  Faulty Reductions
 *      - if operation doesn't follow associative property then it might give faulty results.
 *      -   sum : follows the associative property i.e. (i1+i2)+i3=i1+(i2+i3)
 *          sum of squares is not associative so should not be used with parallel.
 */
@SuppressWarnings("ALL")
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 4)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class E_013_ParallelStreamForkJoin {
    @Param({"10"})
    private int n;

    private Random random = new Random();
    private List<Integer> list;

    @Setup
    public void setup(){
        list = IntStream.range(0, n)
                        .mapToObj(index -> random.nextInt(100))
                        .collect(Collectors.toList());
    }

    @Benchmark
    public double sumNoParallel(){
        return list.stream().mapToInt(i -> i).sum();
    }

    @Benchmark
    public double sumParallel(){
        return list.stream().mapToInt(i -> i).parallel().sum();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(E_013_ParallelStreamForkJoin.class.getName()).build();
        new Runner(opt).run();

        //runInCustomForkJoinPool();
    }

    /**
     *  -   processing in list faster since parallel forking will happen.
     *  -   processing in set is not good idea to work with parallel since
     *      it will be processed by single thread.
     *
     *  Below points to consider :
     *  -   Do not use paraller streams on sources of unknown size.
     *  -   Prefer lists over sets
     *  -   Make sure your source is SIZED and SUBSIZED
     */
    private static void runInCustomForkJoinPool() {
        Set<String> threadNames = ConcurrentHashMap.newKeySet();
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        Callable<Integer> task = () -> {
            int sum = IntStream.range(0, 1_000_000)
                               .map(i -> i*3)
                               .parallel()
                               .peek(i -> threadNames.add(Thread.currentThread().getName()))
                               .sum();
            return sum;
        };
        forkJoinPool.submit(task);
        threadNames.forEach(System.out::println);
        forkJoinPool.shutdown();
    }
}
