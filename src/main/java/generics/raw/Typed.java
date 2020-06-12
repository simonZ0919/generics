package generics.raw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Typed {
    public static void main(String[] args) {
//        List<String> strings = new ArrayList<String>();
        // type inference, since Java7
        List<String> strings = new ArrayList<>();
        strings.add("RAW");
        strings.add("list");
        strings.add("of");
        strings.add("strings");
        // check type in compile time
        // strings.add(789);

        for (String s : strings) {
            System.out.printf("number of characters: %d%n", s.length());
        }
    }
}
