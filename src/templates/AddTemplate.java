package templates;

import java.util.ArrayList;

/**
 * Created by Emily on 2/2/2016.
 * Stores an ArrayList of templates for the Addition
 * operation in the form of Strings
 */
public class AddTemplate extends Template {

    public ArrayList<String> sentences;

    public AddTemplate() {
        sentences = new ArrayList<String>();
        this.addTemplate();
    }

    public void addTemplate() {
        sentences.add("#person1 has #number1 #item. #person2 has #number2 #item. " +
                "How many #item do they have altogether?");
    }

    public ArrayList<String> getTemplate() {
        return sentences;
    }

}
