import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * File: Day1.java
 * Date: 02.12.20
 * Author: Simon Schmitt <sls@sls.wtf>
 */
public class Day1 {

    public static int[] readFile(String filename){

        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                lines.add(bufferedReader.readLine());
            }

            bufferedReader.close();

        } catch (IOException e){
            e.printStackTrace();
        }

        int[] numbers = new int[lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            numbers[i] = Integer.parseInt(lines.get(i));
        }
        return numbers;
    }

    public static void productFinderPart1(int[] forward){
        for (int i = 0; i < forward.length; i++) {
            for (int j = 0; j < forward.length; j++) {
                if ((forward[i] + forward[j]) == 2020){
                    System.out.printf("Part 1: Found %s and %s for 2020 and the product is: %s\n",
                            forward[i],
                            forward[j],
                            forward[i] * forward[j]);
                        return;
                    }
            }
        }

    }
    public static void productFinderPart2(int[] forward){
        for (int i = 0; i < forward.length; i++) {
            for (int j = 0; j < forward.length; j++) {
                for (int k = 0; k < forward.length; k++) {
                    if ((forward[i] + forward[j] + forward[k]) == 2020){
                        System.out.printf("Part 2: Found %s , %s and %s for 2020 and the product is: %s",
                                forward[i],
                                forward[j],
                                forward[k],
                                forward[i] * forward[j] * forward[k]);
                        return;
                }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] numbers = readFile("src/input.txt");

        productFinderPart1(numbers);
        productFinderPart2(numbers);

    }

}
