package worksheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Emily on 2/11/2016.
 */
public class StudentState implements State {

    private Integer currentScore = 0;
    ArrayList<Problem> problems;

    public StudentState(ArrayList<Problem> problems) {
        this.problems = problems;
    }

    public void doAction(Context context) {
        System.out.println("The Worksheet is being filled out by student");
        context.setState(this);
        administerTest();
        outputScore();
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
        System.out.println("\n---------------------------------- FINAL RESULT ----------------------------------");
        System.out.println("You answered " + currentScore + " questions correctly out of " + problems.size() + " problems.");
    }

    public String toString(){
        return "Student State";
    }

    public Integer getScore() {
        return currentScore;
    }

}
