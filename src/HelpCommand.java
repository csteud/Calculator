/**
 * This <code>HelpCommand</code> class implements the Command interface.
 * This command prints the help message to the console window.
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class HelpCommand implements Command {

    /**
     * This <code>run</code> method overrides the Command interface run.
     * This method prints the help message to the console window.
     */
    @Override
    public void run() {
        System.out.println("Calculator Version .1");
        System.out.println("Commands:");
        System.out.println("\tSAVE - Saves the last result to memory.");
        System.out.println("\tMEM - Recalls the saved result and uses it in the current equation.");
        System.out.println("\tPRINT - Shows a log of all successful operations.");
        System.out.println("\tOFF - Exits out of the calculator.");
        System.out.println("Operators:");
        System.out.println("\t+ - Addition");
        System.out.println("\t- - Subtraction");
        System.out.println("\t* - Multiplication");
        System.out.println("\t/ - Division");
        System.out.println("\t~ - Root");
        System.out.println("\t^ - Exponent");
        System.out.println("Examples:");
        System.out.println("\n\tUsing the SAVE and MEM commands:");
        System.out.println("\t\tPlease enter number or command: 10");
        System.out.println("\t\tPlease enter an operator: -");
        System.out.println("\t\tPlease enter number or command: 5");
        System.out.println("\t\t5.0");
        System.out.println("\t\tPlease enter number or command: SAVE");
        System.out.println("\t\tPlease enter number or command: MEM");
        System.out.println("\t\tPlease enter an operator: +");
        System.out.println("\t\tPlease enter number or command: 5");
        System.out.println("\t\t0.0");
    }

}
