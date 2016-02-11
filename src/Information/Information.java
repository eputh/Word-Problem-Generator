package Information;

import java.util.ArrayList;
import java.util.Random;

/**
 * Modified by Emily on 2/3/2016.
 * Handles the gathering of input and information from the user
 */
public class Information {

    public ArrayList<String> typeOfProblems;
    public Integer numOfProblems;
    public Integer minRange;
    public Integer maxRange;
    public ArrayList<Person> names;
    public ArrayList<Item> items;

    public void inputManager() {
        InputManager input = new InputManager();
        input.printWelcomeMessage();
        typeOfProblems = input.promptForOperationTypes();
        numOfProblems = input.promptForNumberOfProblems();
        minRange = input.promptForMinRange();
        maxRange = input.promptForMaxRange();
        names = input.promptForNamesOfInterest();
        items = input.promptForItemsOfInterest();
    }

    public Person generateRandName() {
        Random rand = new Random();
        int n = rand.nextInt(names.size()) + 0;
        return names.get(n);
    }

    public Item generateRandItem() {
        Random rand = new Random();
        int n = rand.nextInt(items.size()) + 0;
        return items.get(n);
    }

    public Integer generateRandNum() {
        Random rand = new Random();
        Integer n = rand.nextInt(maxRange) + minRange;
        return n;
    }
}
