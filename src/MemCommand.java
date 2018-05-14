/**
 * This <code>MemCommand</code> class implements the Command interface.
 * This command returns the double being held in the stack.
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class MemCommand implements Command {

    /**
     * This <code>run</code> method overrides the Command interface run.
     * This calls the method to return what is stored in memory.
     */
    @Override
    public void run() {
        CalculatorMemory.getResultStack();
    }
}
