package worksheet;

import java.util.ArrayList;

/**
 * Created by Emily on 2/2/2016.
 */
public class Worksheet {

    public static void main(String args[]) {
//        Worksheet sheet = new Worksheet();
//        sheet.createProblems();
//        sheet.administerTest();
//        sheet.outputScore();
        Context context = new Context();

        SetUpState startState = new SetUpState();
        startState.doAction(context);
        ArrayList<Problem> problems = startState.getProblems();

        StudentState stopState = new StudentState(problems);
        stopState.doAction(context);
    }
}
