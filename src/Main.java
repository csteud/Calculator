import java.util.Scanner;

/**
 * This <code>Main</code> class is the entry point into the calculator application
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class Main {
    /**
     * This <code>main</code> method starts our calculator application
     *
     * @param args typeof String[] arguments passed in from the command line
     */
    public static void main(String[] args) {

        //calculator is the object for the calculator class
        Calculator calculator = new Calculator();

        //inputScanner is a new scanner object for reading input
        Scanner inputScanner = new Scanner(System.in);

        //isValid is false until we have a valid input for is on
        boolean isValid = false;

        //Loop to have the user turn on or off the calculator
        while (!isValid) {
            //Output to user with instructions
            System.out.print("Type on to turn on the calculator or off to turn it off: ");

            //option stores the next line of input
            String option = inputScanner.next();
            //Creates a new line after input is entered
            System.out.println();

            //Checks to see if the input entered is on
            if (option.equalsIgnoreCase("on")) {
                //Calls the powerOn method in Calculator
                calculator.powerOn();
                //Sets input to true as on is a valid input
                isValid = true;
            }

        }

        //Closes the inputScanner
        inputScanner.close();
    }
}
