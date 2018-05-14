
import java.util.ArrayList;
import java.util.Stack;

/**
 * This <code>CalculatorMemory</code> class contains the operation of mem
 * and history methods.
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class CalculatorMemory {

    /**
     * log is an ArrayList of equations to store our equations for our PRINT command
     */
    private static ArrayList<Equation> log = new ArrayList<>();
    /**
     * resultStack is a Stack of Double that stores our last result when the SAVE command is called
     */
    private static Stack<Double> resultStack = new Stack<>();

    /**
     * This <code>setLog</code> method takes an Equation and adds it to the log
     * ArrayList
     *
     * @param equationObject typeof Equation is the equation to add to the log
     */
    public static void setLog(Equation equationObject) {
        log.add(equationObject);
    }

    /**
     * This <code>getLog</code> method prints the contents for the log ArrayList to the screen
     */
    public static void getLog() {
        for (Equation e : log) {
            System.out.print(e.toString() + "\n\n");
        }
    }

    /**
     * This <code>setResultStack</code> method gets the last result double and stores it in resultStack.
     */
    public static void setResultStack() {
        //Checks to see if the Stack is empty if it is not empty we have to remove the value first and then add it.
        if (resultStack.isEmpty()) {
            //Adds the last result double to the stack.
            resultStack.push(log.get((log.size() - 1)).getResult());
        } else {
            //Removes the value stored in the stack.
            resultStack.pop();
            //Adds the last result double to the stack.
            resultStack.push(log.get((log.size() - 1)).getResult());
        }
    }

    /**
     * This <code>getResultStack</code> returns the first element of the resultsStack.
     *
     * @return Returns typeof double of the first element in the results stack.
     */
    public static double getResultStack() {
        return resultStack.firstElement();
    }
}
