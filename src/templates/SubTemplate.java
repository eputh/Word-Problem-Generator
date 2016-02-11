package templates;

import java.util.ArrayList;

/**
 * Created by Emily on 2/2/2016.
 * Stores an ArrayList of templates for the Subtraction
 * operation in the form of Strings
 */
public class SubTemplate extends Template {

    public ArrayList<String> sentences;

    public SubTemplate() {
        sentences = new ArrayList<String>();
        sentences.add("#person1 has #number1 #item. #gender1 gives #number2 #item to " +
                "#person2. How many #item does #person1 have left?");
    }

    public ArrayList<String> getTemplate() {
        return sentences;
    }

}
