package worksheet;

import Information.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Emily on 2/2/2016.
 */
public class Worksheet {

    private Integer currentScore = 0;
    private ArrayList<Float> scores;
    private ArrayList<Problem> problems;

    public Worksheet() {
        scores = new ArrayList<Float>();
        problems = new ArrayList<Problem>();
    }
    private void createProblems() {
        // collect information
        Information information = new Information();
        information.inputManager();

        // calculate how many problems to generate for each operation
        int numProblemsEach = information.numOfProblems/information.typeOfProblems.size(); // number of problems split by operations evenly
        int numProblemsRemaining = information.numOfProblems - (numProblemsEach * information.typeOfProblems.size());

        // create problem objects
        for (String operation : information.typeOfProblems)
            for (int i=0; i<numProblemsEach; i++)
                problems.add(new Problem(information, operation));

        for (int i=0; i<numProblemsRemaining; i++)
            problems.add(new Problem(information, information.typeOfProblems.get(i)));

        // generate problems for each problem object
        for (Problem p : problems)
            p.generateProblem();
    }

    private void administerTest() {
        // handle input from student
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // shuffle word problems
        Collections.shuffle(problems);

        System.out.println("\n---------------------------------- GENERATED WORKSHEET ----------------------------------");
        for (int i=0; i<problems.size(); i++) {
            Problem p = problems.get(i);
            System.out.println("\n" + (i+1) + ". " + p.getWordProblem());
            try {
                input = br.readLine();
                input = input.replace(" ", "");
                Float answer = Float.parseFloat(input);
                if (answer.equals(p.getAnswer())) {
                    System.out.println("Correct! :)");
                    currentScore+=1;
                }
                else System.out.println("Incorrect :(");
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private void outputScore() {
        scores.add((float)currentScore);
        System.out.println("\n---------------------------------- FINAL RESULT ----------------------------------");
        System.out.println("You answered " + currentScore + " questions correctly out of " + problems.size() + " problems.");
    }

    public static void main(String args[]) {
        Worksheet sheet = new Worksheet();
        sheet.createProblems();
        sheet.administerTest();
        sheet.outputScore();
    }
}
