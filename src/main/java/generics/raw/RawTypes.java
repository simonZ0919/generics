package generics.raw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RawTypes {
    public static void main(String[] args) {
        List strings = new ArrayList();
        strings.add("RAW");
        strings.add("list");
        strings.add("of");
        strings.add("strings");
        // valid here
        // strings.add(123);

        for (Object o : strings) {
            // type cast here
            String s = (String) o;
            System.out.printf("number of characters: %d%n", s.length());
        }
    }
}
