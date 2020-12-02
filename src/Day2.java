import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * File: Day2.java
 * Date: 02.12.20
 * Author: Simon Schmitt <sls@sls.wtf>
 */
public class Day2 {

    private static String[] readFile(String filename){

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

        String[] returnLines = new String[lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            returnLines[i] = lines.get(i);
        }
        return returnLines;
    }

    private static boolean checkValidPart1(String[] temp) {
        String pw = temp[2];
        String[] range = temp[0].split("-");
        int amountCounter = 0;
        int min = Integer.parseInt(range[0]);
        int max = Integer.parseInt(range[1]);

        for (int i = 0; i < pw.length(); i++) {
            if (pw.charAt(i) == temp[1].charAt(0)){
                amountCounter++;
            }
        }

        if (amountCounter >= min && amountCounter <= max){
            return true;
        } else return false;

    }
    private static boolean checkValidPart2(String[] temp) {
        String pw = temp[2];
        String[] range = temp[0].split("-");
        int first = Integer.parseInt(range[0])-1;
        int second = Integer.parseInt(range[1])-1;

        if (pw.charAt(first) == temp[1].charAt(0) ^ pw.charAt(second) == temp[1].charAt(0)){
            return true;
        } else return false;

    }

    public static void main(String[] args) {
        int counterPart1 = 0;
        int counterPart2 = 0;
        String[] pws = readFile("src/input2.txt");
        String[] temp;

        for (int i = 0; i < pws.length; i++) {
            temp = pws[i].split(" ");
            if (checkValidPart1(temp)){
                counterPart1++;
            }
            if (checkValidPart2(temp)){
                counterPart2++;
            }

        }

        System.out.printf("Amount of valid passwords with the first interpretation: %s\n", counterPart1);
        System.out.printf("Amount of valid passwords with the second interpretation: %s", counterPart2);

    }



}
