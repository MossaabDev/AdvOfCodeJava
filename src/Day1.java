import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\MSI\\IdeaProjects\\firstProg\\AdventOfCode\\src\\inputs.txt"));
        String line;
        List<String> numbers = new ArrayList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("five");
        numbers.add("six");
        numbers.add("seven");
        numbers.add("eight");
        numbers.add("nine");
        int result = 0;
        while((line = reader.readLine()) != null){
            String token = "";
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))){
                    integers.add(Character.getNumericValue(line.charAt(i)));
                    token = "";
                }else{
                    token = token + line.charAt(i);
                    for (int j = 0; j < numbers.size(); j++) {
                        if (token.contains(numbers.get(j))){
                            integers.add(j+1);
                            token = String.valueOf(token.charAt(token.length()-1));
                        }
                    }
                }
            }
            result = result + integers.getFirst()*10 + integers.getLast();
        }
        System.out.println(result);
    }
}