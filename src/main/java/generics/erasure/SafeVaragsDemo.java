package generics.erasure;


public class SafeVaragsDemo {
//    @SafeVarargs
    public  static <T> T[] replaceFirstValueInArray(T value, T... array) {
        // Compiles because of type erasure
        // But "possible heap pollution from parameterized vararg type"
        array[0] = value;
        return array;
    }

    public static void main(String[] args) {
        String[] ouput= replaceFirstValueInArray("abc", "b", "h", "j");
        System.out.println(ouput[0]);
    }
}
