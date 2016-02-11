package templates;

import java.util.ArrayList;

/**
 * Created by Emily on 2/2/2016.
 * Stores an ArrayList of templates for the Multiplication
 * operation in the form of Strings
 */
public class MultTemplate extends Template {

    public ArrayList<String> sentences;

    public MultTemplate() {
        sentences = new ArrayList<String>();
        sentences.add("#person1 has #number1 groups of #number2 #item. " +
                "How many #item does #person1 have altogether?");
    }

    public ArrayList<String> getTemplate() {
        return sentences;
    }

}
