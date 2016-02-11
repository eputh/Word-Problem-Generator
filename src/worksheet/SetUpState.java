package worksheet;

import Information.Information;

import java.util.ArrayList;

/**
 * Created by Emily on 2/11/2016.
 */
public class SetUpState implements State {

    ArrayList<Problem> problems;

    public void doAction(Context context) {
        System.out.println("Worksheet is in its setup state");
        context.setState(this);
        createProblems();
    }

    private void createProblems() {
        problems = new ArrayList<Problem>();
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

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public String toString(){
        return "Setup State";
    }

}
