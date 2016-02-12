import worksheet.Worksheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Emily on 2/11/2016.
 */
public class WordProblemGenerator {

    private ArrayList<Float> scoreRecord;

    public WordProblemGenerator() {
        scoreRecord = new ArrayList<Float>();
    }

    private void addScoreToRecord(Float score) {
        scoreRecord.add(score);
    }


    public static void main(String args[]) {
        WordProblemGenerator generator = new WordProblemGenerator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean anotherWorksheet = true;
        while (anotherWorksheet) {
            Worksheet worksheet = new Worksheet();
            generator.addScoreToRecord(worksheet.getScore());
            System.out.println("\nWould you like to generate another worksheet? Y/N");
            try {
                String input = br.readLine();
                input = input.replace(" ", "");
                if (!input.equals("Y")) anotherWorksheet = false;
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }
        for (Float score : generator.scoreRecord) System.out.println(score);
    }

}
