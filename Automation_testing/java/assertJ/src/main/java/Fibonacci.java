import java.util.ArrayList;

public class Fibonacci {

    public static ArrayList<Integer> fibonacci(Integer number) {

        if (number < 0) {
            throw new IllegalArgumentException();
        } else {
            int begin = 0;
            int second = 1;
            int sum = 0;
            int counter = 0;
            ArrayList<Integer> result = new ArrayList<>();
            result.add(begin);
            result.add(second);

            do {
                sum = begin + second;
                result.add(sum);
                begin = second;
                second = sum;
                counter++;
            } while (counter < number - 2);

            return result;
        }
    }
}
