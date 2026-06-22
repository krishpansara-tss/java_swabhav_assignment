import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(11);

        System.out.println(numbers);
        System.out.println();
        numbers.stream().forEach(System.out::print);
        System.out.println();
        numbers.stream().forEach(System.out::println);

        System.out.println();

        numbers.stream().filter((x) -> x % 2 == 0).forEach(System.out::println);
        System.out.println();
        numbers.stream().filter((x) -> x % 2 != 0).forEach(System.out::println);
        System.out.println();

        numbers.stream().map(number -> number * number).forEach(System.out::println);
        System.out.println();
        int sum = numbers.stream().reduce(0, (num1, num2) -> num1 + num2);
        System.out.println(sum);

        Optional<Integer> minVal = numbers.stream().min(Integer::compareTo);
        Optional<Integer> maxVal = numbers.stream().max(Integer::compareTo);
        System.out.println("Min: "+ minVal.get() + "\nmaxVAl:"+maxVal);

        numbers.stream().limit(011).count();
//        .forEach(System.out::println);

        System.out.println();

        long count = numbers.stream().count();
        System.out.println("count : " + count);

        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println(first);

//        Optional<Integer> first = numbers.stream().anyMatch();
        System.out.println(first);


    }
}
