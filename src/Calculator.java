
import java.util.Scanner;

/**
 * This <code>Calculator</code> class is our main calculator class
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class Calculator {

    // inputScanner Scanner is our Scanner object to get input from the console
    private Scanner inputScanner = new Scanner(System.in);

    /**
     * This <code>powerOn</code> starts our calculator
     */
    public void powerOn() {
        System.out.println("Welcome to the calculator. Please specify a problem or command to get started. Type -help for help.");
        runningLoop();
    }

    /**
     * This <code>runningLoop</code> is the loop that loops through the application
     */
    private void runningLoop() {
        //isOn boolean tells the calculator to keep going or to stop
        boolean isOn = true;

        while (isOn) {
            // firstValue Input is our first value Input object
            Input firstValue = new Input(InputType.NUMBER_OR_COMMAND);
            // operator Input is our operator Input object
            Input operator = new Input(InputType.OPERATOR);
            // secondValue Input is our second value Input object
            Input secondValue = new Input(InputType.NUMBER_OR_COMMAND);

            //calls the inputLoop method to get the firstValue from the user
            inputLoop(firstValue);
            //runs any logic needed on the firstValue and will return false if we need to skip the rest of the loop
            if (!firstValueLogic(firstValue)) {
                continue;
            }

            //calls the inputLoop method to get the operator from the user
            inputLoop(operator);

            //calls the inputLoop method to get the second value from the user
            inputLoop(secondValue);

            //runs any logic needed on the secondValue and will return false if we need to skip the rest of the loop
            if (!secondValueLogic(secondValue, operator)) {
                continue;
            }

            //calculation Equation is the new object with the values taken from the user
            Equation calculation = new Equation(firstValue, operator, secondValue);
            //prints the result to the console window by calling the getResult method on calculation
            System.out.println(calculation.getResult());
            //saves the last Equation to the history log
            CalculatorMemory.setLog(calculation);
        }
    }

    /**
     * This <code>inputLoop</code> method is the loop to get our input and keeps prompting till the input is valid
     *
     * @param inputObject typeof Input is the object that we are running the input loop with
     */
    private void inputLoop(Input inputObject) {

        //checks to see if the inputObject is of type NUMBER_OR_COMMAND
        if (inputObject.getType().equals(InputType.NUMBER_OR_COMMAND)) {
            //calls the numberOrCommandInputLoop method and passes the inputObject
            numberOrCommandInputLoop(inputObject);
        } else {
            //calls the operatorInputLoop method and passes the inputObject
            operatorInputLoop(inputObject);
        }
    }

    /**
     * This <code>numberOrCommandInputLoop</code> method is the input loop that gets called for a NUMBER_OR_COMMAND
     * type Input object
     *
     * @param inputObject typeof Input The inputObject for the loop
     */
    private void numberOrCommandInputLoop(Input inputObject) {
        boolean isValid = false;

        //calls the resetInput method to make sure it is ready to run the input loop on
        inputObject.resetInput();
        System.out.print("Please enter number or command: ");
        //calls the setValue method to set the value equal to the user input
        inputObject.setValue(inputScanner.next());

        // the loop to keep asking for the input while the input is invalid
        while (!isValid) {
            // checks to see if the value is invalid if so ask the user to put in a valid command or number
            if (!inputObject.isValidInput()) {
                System.out.println("Please enter a valid command or number: ");
                inputObject.setValue(inputScanner.next());
            } else {
                isValid = true;
            }
        }
    }

    /**
     * This <code>numberOrCommandInputLoop</code> method is the input loop that gets called for a OPERATOR
     * type Input object
     *
     * @param inputObject typeof Input the inputObject for the loop
     */
    private void operatorInputLoop(Input inputObject) {
        boolean isValid = false;

        System.out.print("Please enter an operator: ");
        //calls the setValue method to set the value equal to the user input
        inputObject.setValue(inputScanner.next());

        // the loop to keep asking for the input while the input is invalid
        while (!isValid) {
            // checks to see if the value is invalid if so ask the user to put in a valid operator
            if (!inputObject.isValidInput()) {
                System.out.println("Please enter a valid operator: ");
                inputObject.setValue(inputScanner.next());
            } else {
                isValid = true;
            }
        }
    }

    /**
     * This <code>firstValueLogic</code> method contains the logic to be ran on the first value after getting a
     * valid input
     *
     * @param firstValue typeof Input our first value Input object
     * @return Returns typeof Boolean true to proceed through the loop or false to skip the rest of the loop
     */
    private boolean firstValueLogic(Input firstValue) {
        boolean proceed = true;

        // Checks to see is the value is a mem and sets the double value equal to what is saved in memory
        // and calls the runCommand method on the Input object
        if (firstValue.isCommand() && firstValue.getValue().equalsIgnoreCase("mem")) {
            firstValue.setDoubleValue(CalculatorMemory.getResultStack());
            firstValue.runCommand();
            //Checks to see if the value is a command and if so calls the runCommand method on the Input object
        } else if (firstValue.isCommand()) {
            firstValue.runCommand();
            //sets proceed to false because we don't need to continue through the loop
            proceed = false;
        }

        return proceed;
    }

    /**
     * This <code>secondValueLogic</code> method contains the logic to be ran on the second value after getting a
     * valid input
     *
     * @param secondValue our second value Input object
     * @param operator    our operator Input object
     * @return Returns typeof Boolean true to proceed through the loop or false to skip the rest of the loop
     */
    private boolean secondValueLogic(Input secondValue, Input operator) {
        boolean proceed = true;

        // checks to see if the value is a command and if so calls the runCommand method on the Input object
        if (secondValue.isCommand()) {
            secondValue.runCommand();
            //sets proceed to false because we don't need to continue through the loop
            proceed = false;
            //Checks to see if the value is 0 to let the user know that you can't divide by a zero
        } else if ((secondValue.getDoubleValue() == 0) && (operator.getValue().equals("/"))) {
            System.out.println("Can't divide by 0.");
            //sets proceed to false because we don't need to continue through the loop
            proceed = false;
        }

        return proceed;
    }
}
