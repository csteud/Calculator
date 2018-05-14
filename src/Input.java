
import java.util.regex.Pattern;

/**
 * This <code>Input</code> class is our input object that holds the information about the input
 * and validates it.
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class Input {
    // value String is the raw input from the Scanner
    private String value;
    // doubleValue double is the converted double if the value was a double
    private double doubleValue;
    // currentCommand Command holds our Command object if the value was a command
    private Command currentCommand;
    // isCommand boolean stores the value for if the value was a command or not
    private boolean isCommand = false;
    // type InputType is the type that the input was
    private InputType type;
    // isDouble boolean stores the value for if the value was a double or not
    private boolean isDouble = false;

    /**
     * This <code>setValue</code> method is the set method for value
     *
     * @param value typeof String for our raw input from the scanner
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This <code>getValue</code> method is the get method for value
     *
     * @return Returns typeof String for the value
     */
    public String getValue() {
        return value;
    }

    /**
     * This <code>setDoubleValue</code> method is the set method for doubleValue
     *
     * @param doubleValue typeof double for our doubleValue
     */
    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    /**
     * This <code>getDoubleValue</code> method is the get method for doubleValue
     *
     * @return Returns typeof double of doubleValue
     */
    public double getDoubleValue() {
        return doubleValue;
    }

    /**
     * This <code>getType</code> method is the get Method for type
     *
     * @return Returns typeof InputType of type
     */
    public InputType getType() {
        return type;
    }

    /**
     * This <code>Input</code> constructor is our default constructor
     *
     * @param type typeof InputType is our type of input that the Input object is
     */
    public Input(InputType type) {
        this.type = type;
    }

    /**
     * This <code>isDouble</code> method checks to see if the value is a double and if so saves it to doubleValue
     *
     * @return Returns boolean true if it is a double and false if it isn't
     */
    public boolean isDouble() {

        //Try statement to catch our exception if the value isn't a double
        try {
            // Tries to parse the value and save the value to doubleValue
            doubleValue = Double.parseDouble(value);
            // Sets isDouble to true if it was able to parse the double
            isDouble = true;
        } catch (Exception e) {
            // Sets isDouble to false if an exception
            isDouble = false;
        }
        // returns the isDouble value
        return isDouble;
    }

    /**
     * This <code>isSpecial</code> method checks to see if the value is a special case and if so returns true
     *
     * @return Returns boolean true if the value is a special case
     */
    public boolean isSpecial() {
        // Checking to see if the value is PI and if so sets the doubleValue equal to Math.PI
        if (value.equalsIgnoreCase("pi")) {
            //setting isDouble equal to true since this is a double
            isDouble = true;
            doubleValue = Math.PI;
            //Checks to see if the value is e and if so sets the doubleValue equal to Math.E
        } else if (value.equalsIgnoreCase("e")) {
            //setting isDouble equal to true since this is a double
            isDouble = true;
            doubleValue = Math.E;
        }

        return isDouble;
    }

    /**
     * This <code>isCommand</code> method checks to see if the value is a command and if so returns true
     *
     * @return Returns boolean true if the value is a command
     */
    public boolean isCommand() {

        //This block checks to see if the value matches any of the available commands
        //If it matches an available command it creates and stores the command into the currentCommand variable
        if (value.equalsIgnoreCase("-help")) {
            currentCommand = new HelpCommand();
            isCommand = true;
        } else if (value.equalsIgnoreCase("off") || value.equalsIgnoreCase("exit")) {
            currentCommand = new OffCommand();
            isCommand = true;
        } else if (value.equalsIgnoreCase("print")) {
            currentCommand = new PrintCommand();
            isCommand = true;
        } else if (value.equalsIgnoreCase("mem")) {
            currentCommand = new MemCommand();
            isCommand = true;
        } else if (value.equalsIgnoreCase("save")) {
            currentCommand = new SaveCommand();
            isCommand = true;
        }

        return isCommand;
    }

    /**
     * This <code>isOperator</code> method checks to see if the value is an operator and if so returns true
     *
     * @return Returns boolean true if the value is an operator
     */
    public boolean isOperator() {
        boolean isOperator;

        //the regular expression pattern to check if the value matches an available operator
        final String regex = "[-|*|+|/|%|^|~]";
        //the regular expression Pattern class for the pattern
        final Pattern pattern = Pattern.compile(regex);

        //executes the matches() method on the value and will set isOperator to the result
        isOperator = pattern.matcher(value).matches();

        return isOperator;
    }

    /**
     * This <code>isValidInput</code> method checks to see if the value supplied is a valid input
     *
     * @return Returns boolean true if the value is a valid input
     */
    public boolean isValidInput() {
        boolean isValidInput = false;

        //Checks to see if the value is a double or command or special case if the input type is NUMBER_OR_COMMAND
        if ((type.equals(InputType.NUMBER_OR_COMMAND)) && (isDouble() || isCommand() || isSpecial())) {
            isValidInput = true;
            //Checks to see if the value is a operator if the input type is OPERATOR
        } else if (type.equals(InputType.OPERATOR) && isOperator()) {
            isValidInput = true;
        }

        return isValidInput;
    }

    /**
     * This <code>runCommand</code> method runs the current command in the currentCommand variable
     */
    public void runCommand() {
        //verifies that the Input is a command before trying to run
        if (isCommand()) {
            // calls the run method on the currentCommand
            currentCommand.run();
        }
    }

    /**
     * This <code>isCommand</code> method resets the Input object so that it can be used with another value
     */
    public void resetInput() {
        isCommand = false;
    }
}
