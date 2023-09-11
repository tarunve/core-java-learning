package enhancements;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  ->  A teeing collector has been exposed as a static method Collectors::teeing. This collector
 *      forwards its input to two other collectors before merging their results with a function.
 *
 *  ->  teeing(Collector, Collector, BiFunction) accepts two collectors and a function to merge
 *      their results. Every element passed to the resulting collector is processed by both
 *      downstream collectors, then their results are merged using the specified merge function
 *      into the final result.
 */
public class E_001_CollectorsAPIChanges {

    private SalaryRange getSalaryRange() {
        return Stream
                .of(56700, 67600, 45200, 120000, 77600, 85000)
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        SalaryRange::fromOptional));
    }

    public static void main(String[] args) {
        System.out.println(new E_001_CollectorsAPIChanges().getSalaryRange());
    }
}

class SalaryRange {

    Integer min, max;

    SalaryRange(Integer i1, Integer i2) {
        this.min = i1;
        this.max = i2;
    }

    public static SalaryRange fromOptional(Optional<Integer> val1, Optional<Integer> val2)
    {
        return new SalaryRange(val1.orElse(0), val2.orElse(0));
    }

    @Override
    public String toString() {
        return String.format("SalaryRange[%d - %d]", min, max);
    }
}
