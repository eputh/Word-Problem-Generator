package operations;

/**
 * Created by Emily on 2/10/2016.
 * Design pattern - factory method
 */
public class OperationFactory {

    public Operation createOperation(String type) {
        Operation problem = new Addition();
        if (type.equals("+")) problem = new Addition();
        else if (type.equals("-")) problem = new Subtraction();
        else if (type.equals("*")) problem = new Multiplication();
        else if (type.equals("/")) problem = new Division();

        return problem;
    }

}
