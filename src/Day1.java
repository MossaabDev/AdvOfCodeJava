import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\MSI\\IdeaProjects\\firstProg\\AdventOfCode2023\\src\\input.txt"));
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        String line = new String();
        int result = 0;
        int index = 0;
        while ((line = reader.readLine()) != null){
            List<Integer> integers = new ArrayList<>();

            String token = new String();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))){
                    integers.add(Character.getNumericValue(line.charAt(i)));
                    token = "";
                }else{
                    token = token + line.charAt(i);
                    for (int j = 1; j <= numbers.size(); j++) {
                        if (token.contains(numbers.get(j))){
                            integers.add(j);
                            token = String.valueOf(token.charAt(token.length() -1));
                        }
                    }
                }

            }

            result = result + integers.getFirst()*10 + integers.getLast();
            System.out.println(integers.getFirst()*10 + integers.getLast());

        }

        System.out.println(result);

    }
}