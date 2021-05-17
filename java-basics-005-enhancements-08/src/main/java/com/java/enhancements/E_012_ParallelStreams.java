package com.java.enhancements;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  JMH (Java Microbench Harness
 *  -   Correct way to measure performance of your java programs.
 */
@SuppressWarnings("ALL")
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 4)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class E_012_ParallelStreams {

    @Param({"10"})
    private int n;

    @Param({"64"})
    private  int BIT_LENGTH;

    BigInteger probablePrime(){
        return BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current());
    }

    @Benchmark
    public List<BigInteger> sumOfNPrimes(){
        List<BigInteger> l = new ArrayList<>();
        for(int i=0; i<n; i++){
            BigInteger pp = BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current());
            l.add(pp);
        }
        return l;
    }

    @Benchmark
    public List<BigInteger> sumOfNPrimesNoResize(){
        List<BigInteger> l = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            BigInteger pp = BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current());
            l.add(pp);
        }
        return l;
    }

    @Benchmark
    public List<BigInteger> generateNPrimesParallel(){
        return IntStream.range(0, n).parallel()
                .mapToObj(i -> probablePrime())
                .collect(Collectors.toList());
    }

    @Benchmark
    public List<BigInteger> generateNPrimesParallelUnorderes(){
        return IntStream.range(0, n)
                .unordered()
                .parallel()
                .mapToObj(i -> probablePrime())
                .collect(Collectors.toList());
    }

    @Benchmark
    public List<BigInteger> generateNPrimes(){
        return IntStream.range(0, n)
                .mapToObj(i -> probablePrime())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(E_012_ParallelStreams.class.getName()).build();
        new Runner(opt).run();
    }

}
