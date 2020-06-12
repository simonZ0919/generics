package generics.erasure;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ProcessName {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String applyFilter(UnaryOperator<String> filter) {
        return filter.apply(name);
    }

//    @SafeVarargs
    public final String applyFilters(Function<String,String>... filters) {
        return Arrays.stream(filters)
                .reduce(Function.identity(), Function::andThen)
                .apply(name);
    }
}
