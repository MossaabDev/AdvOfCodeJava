import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {
    static int N = 0;
    static List<List<Character>> engine = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String line;

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\MSI\\IdeaProjects\\firstProg\\AdventOfCode2023\\src\\input.txt"));
        int count = 0;
        int result = 0;
        List<Number> numbers = new ArrayList<>();
        while ((line = reader.readLine()) != null){
            char[] chars = line.toCharArray();
            N = line.length();
            Number number;
            engine.add(new ArrayList<>());
            for (int i = 0; i < chars.length; i++) {
                engine.get(count).add(chars[i]);
            }
            for (int i = 0; i < chars.length; i++) {
                number = new Number();
                if (Character.isDigit(chars[i])){
                    number.start = new Point(count, i);
                    number.value = Character.getNumericValue(chars[i]);

                    while(i+1 < chars.length && Character.isDigit(chars[i+1])){
                        i++;
                        number.value = Integer.parseInt(String.valueOf(number.value) + chars[i]);
                    }
                    number.end = new Point(count, i);
                    numbers.add(number);
                    number = new Number();
                }

            }
            count++;
        }

        for (int i = 0; i < engine.size(); i++){
            for (int j = 0; j <engine.get(i).size() ; j++) {
                System.out.print(engine.get(i).get(j));
            }
            System.out.println("\n");
        }
        for (Number number: numbers) {
            System.out.println(number.value + " start -> " + number.start.toString()+"  end -> "+ number.end.toString());
            if (checkBorders(number)){
                result = result + number.value;
            }
        }
        result = 0;
        for (int i = 0; i < engine.size(); i++){
            for (int j = 0; j <engine.get(i).size() ; j++) {
                if (testSymbol(engine.get(i).get(j))){
                    System.out.println(engine.get(i).get(j) + " -> " + checkAround(new Point(i,j), numbers));
                    result = result + checkAround(new Point(i,j), numbers);
                }

            }
        }
        System.out.println(result);
    }

    public static boolean testSymbol(char c){
        if (c != '.' && !Character.isDigit(c)){
            return true;
        }
        return false;
    }

    public static int checkAround(Point point, List<Number> numbers){
        //checkAbove
        int count = 0;
        int output = 1;
        for (Number number: numbers) {
            if ((point.x == number.start.x - 1|| point.x == number.start.x + 1) && point.y >= number.start.y-1 && point.y <= number.end.y+1){
                System.out.println(point.toString() + " -> -> " + number.value);
                count++;
                output = output * number.value;
            }else{
                if (point.x == number.start.x && (point.y == number.start.y -1 || point.y == number.end.y+1)){
                    count++;
                    output = output * number.value;
                }
            }


        }
        if (count> 1){
            return output;
        }else{
            return 0;
        }
    }
    public static boolean checkBorders(Number number){
        int testStart = (number.start.y == 0) ? 0: number.start.y -1;
        int testEnd = (number.end.y == N-1) ? N-1: number.end.y +1;
        //test abobe
        if (number.start.x > 0){
            for (int i = testStart; i<= testEnd; i++){
                if(testSymbol(engine.get(number.start.x - 1).get(i))){
                    return true;
                }
            }
        }

        //test below
        if (number.start.x +1 < engine.size()){
            for (int i = testStart; i<= testEnd; i++){
                if(testSymbol(engine.get(number.start.x + 1).get(i))){
                    return true;
                }
            }
        }

        //test left

        if (number.start.y != 0){
            if (testSymbol(engine.get(number.start.x).get(number.start.y-1))){
                return true;
            }
        }

        //test right

        if (number.end.y != N-1){
            if (testSymbol(engine.get(number.start.x).get(number.end.y+1))){
                return true;
            }
        }

        return false;
    }
}
