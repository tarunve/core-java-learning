package enhancements;

import java.util.SplittableRandom;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * - “Enhanced Pseudo-Random Number Generators” introduced under Java 17 Features. This feature provides
 *   additional pseudo-random number generators (PRNGs) that can be used to generate random numbers in
 *   Java applications. The new PRNGs are designed to be faster and more secure than the existing PRNGs
 *   in Java.
 * - The new PRNGs are implemented as instances of the SplittableRandom class, which provides a way to
 *   generate a sequence of pseudo-random numbers that can be split and used to create new PRNG instances.
 *   This allows multiple threads to generate random numbers independently and with low contention, which
 *   can improve performance in multi-threaded applications.
 * - With the introduction of RandomGenerator interface, we can inject any implementing generator class
 *   where the client uses RandomGenerator type in the application code. The new classes are:
 *   - SplittableGenerator : can be split into two objects (the original one and a new one) each of which
 *                          obeys that same protocol.
 *   - JumpableGenerator – can easily jump forward, by a moderate amount.
 *   - LeapableGenerator – can easily not only jump but also leap forward, by a large amount.
 *   - ArbitrarilyJumpableGenerator – can easily jump forward, by an arbitrary amount, to a distant point
 *                                    in the state cycle.
 *   - StreamableGenerator – augments the RandomGenerator interface to provide methods that return
 *                           streams of RandomGenerator objects.
 *
 *
 *   RandomGeneratorFactory
 *   ======================
 *   - The RandomGeneratorFactory provides methods for selecting random number generator algorithms.
 *     We can choose a particular algorithm by its name and use it for generating random numbers.
 *   - The default algorithm is L32X64MixRandom. Following is the list of all supported algorithms:
 *     L128X1024MixRandom , L128X128MixRandom , L128X256MixRandom , L32X64MixRandom , L64X1024MixRandom ,
 *     L64X128MixRandom , L64X128StarStarRandom , L64X256MixRandom , Random (Legacy) , SecureRandom (Legacy) ,
 *     SplittableRandom (Legacy) , Xoroshiro128PlusPlus , Xoshiro256PlusPlus
 */
public class E_003_EnhancedPseudoRandomGenerators {

    public static void splittableRandomGenerator() {
        SplittableRandom random = new SplittableRandom();
        // The nextInt() method returns a pseudo-random integer that is uniformly distributed
        // between Integer.MIN_VALUE and Integer.MAX_VALUE.
        int randomNumber = random.nextInt();
        System.out.println(randomNumber);

        // random in range
        int randomNumberInRange = random.nextInt(10, 20);
        System.out.println(randomNumberInRange);

        // split to create a new instance that generates an independent sequence of random numbers.
        SplittableRandom random1 = new SplittableRandom();
        SplittableRandom random2 = random1.split();
        System.out.println(random1.nextInt());
        System.out.println(random2.nextInt());
    }

    public static void randomGeneratorFactory() {
        // Random Generator Factory
        RandomGeneratorFactory<RandomGenerator> factory = RandomGeneratorFactory.of("SecureRandom");
        RandomGenerator r = factory.create(200L);
        //get random numbers
        System.out.println(r.nextDouble());
    }

    public static void main(String[] args) {
        splittableRandomGenerator();
        randomGeneratorFactory();
    }
}
