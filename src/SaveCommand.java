/**
 * This <code>SaveCommand</code> class implements the Command interface.
 * This command saves the last result to memory.
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class SaveCommand implements Command {

    /**
     * This <code>run</code> overrides the Command interface run.
     * This calls the method to add the last result to the memory stack.
     */
    @Override
    public void run() {
        CalculatorMemory.setResultStack();
    }
}
