package com.pluralsight.calcengine;

public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers) {
        this.handlers = handlers;
    }

    public String process(String statement) {
        // IN: add 1.0 2.0
        // OUT: 1.0 + 2.0 = 3.0

        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyword = parts[0];

        MathProcessing theHandler = null;

        for (MathProcessing handler: handlers) {
            if (keyword.equalsIgnoreCase(handler.getKeyword())) {
                theHandler = handler;
                break;
            }
        }

        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);

        double result = theHandler.doCalculation(leftVal, rightVal);

        return String.format("%.2f %c %.2f = %.2f", leftVal, theHandler.getSymbol(), rightVal, result);
    }
}
