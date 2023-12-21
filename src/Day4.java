import javax.imageio.ImageTranscoder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {

    public static void main(String[] args) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\MSI\\IdeaProjects\\firstProg\\AdventOfCode2023\\src\\input.txt"));
        int result = 0;
        while((line = reader.readLine()) != null){
            int count = -1;
            String[] strings = line.split(":");
            int n = strings[1].split("\\|")[1].trim().split("\\s+").length;
            System.out.println(Arrays.toString(strings[1].split("\\|")[0].split("\\s+")));
            List<Integer> winning = new ArrayList<>();
            List<Integer> mine = new ArrayList<>();
            System.out.println(Arrays.toString(strings[1].trim().split("\\|")[0].trim().split("\\s+")));
            System.out.println(Arrays.toString(strings[1].trim().split("\\|")[1].trim().split("\\s+")));

            for (int i = 0; i < strings[1].trim().split("\\|")[0].trim().split("\\s+").length; i++) {
                winning.add(Integer.parseInt(strings[1].trim().split("\\|")[0].trim().split("\\s+")[i]));
            }
            System.out.println("N -> " + n);
            for (int i = 0; i < n; i++) {
                mine.add(Integer.parseInt(strings[1].trim().split("\\|")[1].trim().split("\\s+")[i]));
                if (winning.contains(mine.get(i))){
                    System.out.print("   " + mine.get(i));
                    count++;

                }
            }

            result = (int) (result + Math.pow(2, count));
            System.out.println(result);

        }
        System.out.println(result);
    }

}
