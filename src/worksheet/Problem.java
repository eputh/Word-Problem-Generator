package worksheet;

import operations.*;
import Information.*;

/**
 * Created by Emily on 2/4/2016.
 */
public class Problem {

    private String problemType; // operation
    private Information info;
    private String wordProblem;
    private Float answer;

    public Problem(Information info, String problemType) {
        this.problemType = problemType;
        this.info = info;
    }

    public Operation generateProblem() {
        OperationFactory factory = new OperationFactory();
        Operation problem = factory.createOperation(problemType);
        wordProblem = problem.createWordProblem(info);
        answer = problem.checkAnswer();

        return problem;
    }

    public String getWordProblem() {
        return wordProblem;
    }

    public Float getAnswer() {
        return answer;
    }

}
