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

    public static int[] reverseArray(int[] arr){
        ArrayList<Integer> reversed = new ArrayList<>();
        int[] reversedArray = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            reversed.add(arr[i]);
        }

        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = reversed.get(i);
        }
        return reversedArray;
    }

    public static void productFinder(int[] forward, int[] reversed){
        for (int i = 0; i < forward.length; i++) {
            for (int j = 0; j < reversed.length; j++) {
                if ((forward[i] + reversed[j]) == 2020){
                    System.out.printf("Found %s and %s for 2020 and the product is: %s", forward[i], reversed[j], forward[i] * reversed[j]);
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] numbers = readFile("src/input.txt");
        int[] reversed = reverseArray(numbers);

        productFinder(numbers, reversed);

    }

}
