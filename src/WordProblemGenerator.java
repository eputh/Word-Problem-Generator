import worksheet.Worksheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Emily on 2/11/2016.
 */
public class WordProblemGenerator {

    private Map<Integer, Float> scoreRecord;

    public WordProblemGenerator() {
        scoreRecord = new HashMap<Integer, Float>();
    }

    private void addScoreToRecord(Integer worksheetID, Float score) {
        scoreRecord.put(worksheetID, score);
    }


    public static void main(String args[]) {
        WordProblemGenerator generator = new WordProblemGenerator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        boolean anotherWorksheet = true;
        while (anotherWorksheet) {
            Worksheet worksheet = new Worksheet();
            generator.addScoreToRecord(i, worksheet.getScore());
            System.out.println("\nWould you like to generate another worksheet? Y/N");
            try {
                String input = br.readLine();
                input = input.replace(" ", "");
                if (!input.equals("Y")) anotherWorksheet = false;
                else i++;
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }
        for (Map.Entry<Integer, Float> entry : generator.scoreRecord.entrySet()) System.out.println(entry.getKey() + ": " + entry.getValue());
    }

}
