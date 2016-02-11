package operations;

import Information.*;

import java.util.ArrayList;

/**
 * Created by Emily on 2/3/2016.
 * The Operation class is used to hide the implementation details
 * of the many different types of operations
 */
public abstract class Operation {

    private ArrayList<Person> names;
    private ArrayList<Item> items;
    private ArrayList<Integer> values;

    public abstract String createWordProblem(Information info);
    public abstract Float checkAnswer();

}
