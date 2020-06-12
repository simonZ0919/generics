package generics.inheritance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class BasicInheritance {
    public static void main(String[] args) {
        Object[] objects = new Integer[2];
        objects[0] =3;
        objects[1] ="test";//Runtime error

        // not compile
        // List<Object> objectList = new ArrayList<Integer>();
    }
}
