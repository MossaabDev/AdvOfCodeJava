import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {

    public static void main(String[] args) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\MSI\\IdeaProjects\\firstProg\\AdventOfCode2023\\src\\input.txt"));
        int count = 0;
        while ((line = reader.readLine()) != null){
                count = count + test(line);
        }
        System.out.println(count);
    }

    public static int test(String line){
        Map<String, Integer> cubes  = new HashMap<>();
        line = line.split(":")[1];
        List<String> subsets = new ArrayList<>(List.of(line.split(";")));
        cubes = new HashMap<>();
        cubes.put("red", 0);
        cubes.put("green", 0);
        cubes.put("blue", 0);
        for (String s : subsets) {
            String[] strings = s.trim().split(",");
            for (int i = 0; i < strings.length; i++) {
                if (cubes.get(strings[i].trim().split(" ")[1]) < Integer.parseInt(strings[i].trim().split(" ")[0])){
                    cubes.put(strings[i].trim().split(" ")[1], Integer.parseInt(strings[i].trim().split(" ")[0]));
                }
            }

        }

        return cubes.get("red")* cubes.get("blue") * cubes.get("green");
    }


}
