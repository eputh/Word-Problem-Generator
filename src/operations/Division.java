package operations;

import Information.*;
import templates.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Emily on 2/3/2016.
 */
public class Division extends Operation {

    private ArrayList<Person> names;
    private ArrayList<Item> items;
    private ArrayList<Integer> values;
    public Float answer;

    public Division () {
        names = new ArrayList<Person>();
        items = new ArrayList<Item>();
        values = new ArrayList<Integer>();
    }

    public String createWordProblem(Information info) {
        // get a template
        Template templates = new DivTemplate();
        ArrayList<String> opList = templates.getTemplate();
        String wordProblem = opList.get(0);

        // get random names, items, and numbers to plug into the template
        Person person1 = info.generateRandName();
        Item item = info.generateRandItem();
        Integer number1 = info.generateRandNum();
        Integer number2 = info.generateRandNum();

        // add gathered info into their corresponding lists
        names.add(person1);
        items.add(item);
        values.add(number1); values.add(number2);
        // sort values list
        Collections.sort(values);
        number1 = values.get(values.size()-1);
        number2 = values.get(0);

        // add gathered info into the template
        wordProblem = wordProblem.replace("#person1", person1.name);
        String pronoun = person1.gender.toLowerCase().equals("male") ? "He" : "She";
        wordProblem = wordProblem.replace("#gender1", pronoun);
        wordProblem = wordProblem.replace("#item", item.item +"s");
        wordProblem = wordProblem.replace("#number1", Integer.toString(number1)); // get the max value
        wordProblem = wordProblem.replace("#number2", Integer.toString(number2)); // get the min value

        return wordProblem;
    }

    public Float checkAnswer() {
        Float result = ((float)values.get(0))/values.get(1);
        DecimalFormat form = new DecimalFormat("0.00");
        answer = Float.parseFloat(form.format(result));
        return answer;
    }

}
