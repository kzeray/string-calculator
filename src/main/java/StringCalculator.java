import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        Pattern pattern = Pattern.compile("[-+]?\\d+");

        Matcher matcher = pattern.matcher(numbers);
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        while (matcher.find()) {
            String numberStr = matcher.group();
            int number = Integer.parseInt(numberStr);
            if (number > 0 && number < 1000) {
                positives.add(number);
            } else if (number < 0) {
                negatives.add(number);
            }
        }

        if (negatives.isEmpty()) {
            return positives.stream().mapToInt(Integer::intValue).sum();
        }
        throw new NegativeNumberException("Negatives not allowed: " + negatives);
    }
}
