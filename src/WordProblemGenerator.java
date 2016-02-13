import worksheet.Worksheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import java.io.*;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

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

    private void writeScoreRecordToFile(WordProblemGenerator generator, String filename) {
        try (BufferedWriter scoreWriter = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<Integer, Float> entry : generator.scoreRecord.entrySet()) {
                scoreWriter.write(entry.getValue() + ", " + entry.getKey());
                scoreWriter.flush();
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    private void createLineChart(File recordFile) {
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        try (BufferedReader br = new BufferedReader(new FileReader(recordFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataPair = line.split(", ");
                int score = Integer.parseInt(dataPair[0]);
                line_chart_dataset.addValue(score, "score", dataPair[1]);
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Worksheet Scores","Date",
                "Score",
                line_chart_dataset,PlotOrientation.VERTICAL,
                true, true, false);


        int width = 1500; /* Width of the image */
        int height = 500; /* Height of the image */
        File lineChart = new File( "LineChart.jpeg" );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String args[]) {
        File recordFile = new File(args[0]);
        WordProblemGenerator generator = new WordProblemGenerator();
        generator.createLineChart(recordFile);

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
        generator.writeScoreRecordToFile(generator, "score_record.txt");
//        generator.createLineChart(recordFile);
    }

}
