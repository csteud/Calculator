/**
 * This <code>OffCommand</code> class implements the Command interface.
 * This command exits the application when called.
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class OffCommand implements Command {

    /**
     * This <code>run</code> method overrides the Command interface run,
     * prints a message to the screen and
     * calls the System.exit method to exit.
     */
    @Override
    public void run() {
        System.out.println("Quitting...");
        //Used to exit the application with error code 0.
        System.exit(0);
    }
}
