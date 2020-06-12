package generics.wildcards;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class UpperBounds {
    private static double sumList(List<? extends Number> list) {
        // Java 7
//        double total = 0;
//        for (Number n : numbers) {
//            total += n.doubleValue();
//        }
//        return total;
        return list.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }

    public static void main(String[] args) {
        // unbound
        List<?> stuff = Arrays.asList("Hello", LocalDate.now(), 3);
        System.out.println(stuff.size());
//        stuff.add('something');

        // upper bound
        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<BigDecimal> bigDecimals = IntStream.rangeClosed(1, 5)
                .mapToObj(BigDecimal::new)
                .collect(Collectors.toList());

        System.out.println(sumList(doubles));
        System.out.println(sumList(bigDecimals));

        // lower bound
        List<String> strings = Stream.of("ab", "c", "de").collect(Collectors.toList());
        strings.forEach((Object o) -> System.out.printf("%s has hashCode %d%n", o, o.hashCode()));
    }
}
