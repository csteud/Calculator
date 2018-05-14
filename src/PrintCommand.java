/**
 * This <code>PrintCommand</code> class implements the Command interface.
 * This command returns the history of operations completed.
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class PrintCommand implements Command {

    /**
     * This <code>run</code> method overrides the command interface run and
     * calls the method to print the history of operations completed.
     */
    @Override
    public void run() {
        CalculatorMemory.getLog();
    }
}
