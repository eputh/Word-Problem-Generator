package Information;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // Welcome message
        System.out.println("Welcome to the Word Problem Generator Program!\n" +
                "Let's set up a new worksheet.\n");

        // gather operation types
        System.out.println("Please indicate the type(s) of operations you would " +
                "like to generate word problems for: \n" +
                "   Type + for Addition\n   Type - for Subtraction\n" +
                "   Type * for Multiplication\n   Type / for Division\n" +
                "***** Press ENTER when complete. *****");
        try {
            input = br.readLine();
            input = input.replace(" ", "");
            String[] inputList = input.split("");
            typeOfProblems = new ArrayList<String>(Arrays.asList(inputList));
        }
        catch (IOException e) {
            System.err.println(e);
        }

        // gather number of problems to generate
        System.out.println("\nHow many word problems would you like to generate?");
        try {
            input = br.readLine();
            input = input.replace(" ", "");
            numOfProblems = Integer.parseInt(input);
        } catch (IOException e) {
            System.err.println(e);
        }

        // gather minimum range
        System.out.println("\nWhat is the minimum range for operand values?");
        try {
            input = br.readLine();
            input = input.replace(" ", "");
            minRange = Integer.parseInt(input);
        }
        catch (IOException e) {
            System.err.println(e);
        }

        // gather maximum range
        System.out.println("\nWhat is the  maximum range for operand values?");
        try {
            input = br.readLine();
            input = input.replace(" ", "");
            maxRange = Integer.parseInt(input);
        }
        catch (IOException e) {
            System.err.println(e);
        }

        // gather names of interest
        names = new ArrayList<Person>();
        System.out.println("\nPlease list the names of interest in the following format: \n" +
                "Name1-gender, Name2-gender, Name3-gender...\n   e.g. Chris-male, Emily-female\nThen press ENTER.");
        try {
            input = br.readLine();
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

        // gather items of interest
        items = new ArrayList<Item>();
        System.out.println("\nPlease list the items of interest separated by a comma." +
                "\nThen press ENTER.");
        try {
            input = br.readLine();
            input = input.replace(" ", "");
            String[] itemsList = input.split(",");
            for (String item : itemsList)
                items.add(new Item(item));
        }
        catch (IOException e) {
            System.err.println(e);
        }
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
