import java.util.Arrays;
import java.util.List;
public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 10, 7, 6);
        System.out.println("Các số chẵn trong danh sách:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n));
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Tổng các số trong danh sách: " + sum);
    }
}
