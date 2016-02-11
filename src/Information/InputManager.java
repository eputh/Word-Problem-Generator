package Information;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Emily on 2/10/2016.
 * Handles the initial input gathered from the user (teacher/parent)
 * Created as a consequence of a "bad smell" in the code. InputManager
 * was once a very long method
 */
public class InputManager {

    BufferedReader br;

    public InputManager() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void printWelcomeMessage() {
        // Welcome message
        System.out.println("Welcome to the Word Problem Generator Program!\n" +
                "Let's set up a new worksheet.\n");
    }

    /**
     * Prompts the user to input the type(s) of operations they would
     * like to generate word problems for
     * @return typesOfProblems : an ArrayList of the operations types represented by Strings
     */
    public ArrayList<String> promptForOperationTypes() {
        ArrayList<String> typeOfProblems = new ArrayList<String>();
        System.out.println("Please indicate the type(s) of operations you would " +
                "like to generate word problems for: \n" +
                "   Type + for Addition\n   Type - for Subtraction\n" +
                "   Type * for Multiplication\n   Type / for Division\n" +
                "***** Press ENTER when complete. *****");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            String[] inputList = input.split("");
            typeOfProblems = new ArrayList<String>(Arrays.asList(inputList));
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return typeOfProblems;
    }

    /**
     * Gathers the number of problems to generate from the user
     * @return numOfProblems : Integer
     */
    public Integer promptForNumberOfProblems() {
        Integer numOfProblems=0;
        System.out.println("\nHow many word problems would you like to generate?");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            numOfProblems = Integer.parseInt(input);
        } catch (IOException e) {
            System.err.println(e);
        }
        return numOfProblems;
    }

    /**
     * Gathers the minimum possible operand to be used in a word problem
     * @return minRange : Integer
     */
    public Integer promptForMinRange() {
        Integer minRange = 0;
        System.out.println("\nWhat is the minimum range for operand values?");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            minRange = Integer.parseInt(input);
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return minRange;
    }

    /**
     * Gathers the maximum possible operand to be used in a word problem
     * @return maxRange : Integer
     */
    public Integer promptForMaxRange() {
        Integer maxRange = 0;
        System.out.println("\nWhat is the  maximum range for operand values?");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            maxRange = Integer.parseInt(input);
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return maxRange;
    }

    /**
     * Gathers the names of interest to be used in the template
     * @return names : ArrayList<Person> with name and gender attributes
     */
    public ArrayList<Person> promptForNamesOfInterest() {
        ArrayList<Person> names = new ArrayList<Person>();
        System.out.println("\nPlease list the names of interest in the following format: \n" +
                "Name1-gender, Name2-gender, Name3-gender...\n   e.g. Chris-male, Emily-female\nThen press ENTER.");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            String[] namesList = input.split(",");
            for (String pair : namesList) {
                String[] splitPair = pair.split("-");
                names.add(new Person(splitPair[0], splitPair[1]));
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return names;
    }

    /**
     * Gathers items of interest to be used in the template
     * @return items : ArrayList<Item>
     */
    public ArrayList<Item> promptForItemsOfInterest() {
        ArrayList<Item> items = new ArrayList<Item>();
        System.out.println("\nPlease list the items of interest separated by a comma." +
                "\nThen press ENTER.");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            String[] itemsList = input.split(",");
            for (String item : itemsList)
                items.add(new Item(item));
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return items;
    }
}
