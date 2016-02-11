package templates;

import java.util.ArrayList;

/**
 * Created by Emily on 2/2/2016.
 * Stores an ArrayList of templates for the Division
 * operation in the form of Strings
 */
public class DivTemplate extends Template {

    public ArrayList<String> sentences;

    public DivTemplate() {
        sentences = new ArrayList<String>();
        sentences.add("#person1 has #number1 #item. #gender1 wants to divide them evenly " +
                "among #number2 friends. How many #item does each friend get?");
    }

    public ArrayList<String> getTemplate() {
        return sentences;
    }

}
