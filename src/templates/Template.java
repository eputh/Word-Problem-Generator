package templates;

import java.util.ArrayList;

/**
 * Created by Emily on 2/2/2016.
 * The Template class is an abstract class used to
 * store templates according to operation types
 */
public abstract class Template {

    public ArrayList<String> sentences;

    public abstract ArrayList<String> getTemplate();

}
