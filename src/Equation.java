/**
 * This <code>Equation</code> class contains the methods for executing the calculations.
 *
 * @author Cory Steudeman
 * @version 0.1
 * @date May 2, 2018
 */
public class Equation {
    // firstValue Input is the first value in the operation
    private Input firstValue;
    // operator Input is the operator to tell which operation to perform
    private Input operator;
    // secondValue Input is the second value in the operation
    private Input secondValue;
    // result stores the result of the operation
    private double result;

    /**
     * This <code>execute</code> method is called to execute the calculation based on the operator specified
     * and save it to result.
     */
    private void execute() {

        //initialize the result double
        result = 0;

        //The block of code that executes the calculation specified by the operator.
        try {
            if (operator.getValue().equals("+")) {
                result = firstValue.getDoubleValue() + secondValue.getDoubleValue();
            } else if (operator.getValue().equals("-")) {
                result = firstValue.getDoubleValue() - secondValue.getDoubleValue();
            } else if (operator.getValue().equals("*")) {
                result = firstValue.getDoubleValue() * secondValue.getDoubleValue();
            } else if (operator.getValue().equals("/")) {
                result = firstValue.getDoubleValue() / secondValue.getDoubleValue();
            } else if (operator.getValue().equals("%")) {
                result = firstValue.getDoubleValue() % secondValue.getDoubleValue();
            } else if (operator.getValue().equals("^")) {
                result = Math.pow(firstValue.getDoubleValue(), secondValue.getDoubleValue());
            } else if (operator.getValue().equals("~")) {
                result = nthroot(firstValue.getDoubleValue(), secondValue.getDoubleValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * This <code>nthroot</code> method calculates the root with the supplied values
     *
     * @param rootValue  typeof double is our first number in the root equation
     * @param inputValue typeof double is our second number in the root equation
     * @return typeof double Returns the rootValue root of the inputValue.
     */
    private double nthroot(double rootValue, double inputValue) {
        if (inputValue < 0) {
            //Makes sure that our value is a positive number
            System.err.println("inputValue < 0");
            return -1;
        } else if (inputValue == 0) {
            return 0;
        }
        double x_prev = inputValue;
        double x = inputValue / rootValue;
        while (Math.abs(x - x_prev) > .001) {
            x_prev = x;
            x = ((rootValue - 1.0) * x + inputValue / Math.pow(x, rootValue - 1.0)) / rootValue;
        }
        return x;
    }

    /**
     * This <code>getResult</code> method runs the execute method to run the operation and then returns the result.
     *
     * @return Returns typeof double of our result from the calculation.
     */
    public double getResult() {
        execute();
        return result;
    }

    /**
     * This <code>Equation</code> constructor is the constructor for the Equation class
     *
     * @param firstValue  typeof Input the first value for the calculation
     * @param operator    typeof Input the operator for the calculation
     * @param secondValue typeof Input the second value for the calculation
     */
    public Equation(Input firstValue, Input operator, Input secondValue) {
        this.firstValue = firstValue;
        this.operator = operator;
        this.secondValue = secondValue;
    }

    /**
     * This <code>toString</code> returns a formatted string of the equation
     *
     * @return Returns typeof String.format of the equation
     */
    @Override
    public String toString() {
        return String.format("%n%f %s %f = %f", firstValue.getDoubleValue(), operator.getValue(), secondValue.getDoubleValue(), result);
    }
}
