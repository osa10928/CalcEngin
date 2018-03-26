package com.pluralsight.calcengine;

public class MathEquation {

    private double leftVal;
    private double rightVal;
    private char opCode = 'a';
    private double results;

    public double getLeftVal() { return leftVal; }
    public void setLeftVal(double leftVal) { this.leftVal = leftVal; };

    public double getRightVal() { return rightVal; }
    public void setRightVal(double rightVal) { this.rightVal = rightVal; }

    public char getopCode() { return opCode; }
    public void setOpCode(char opCode) { this.opCode = opCode; }

    public double getResults() { return results; }

    public MathEquation() {}

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    //overloading example
    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    public void execute() {
        switch(opCode) {
            case 'a':
                results = leftVal + rightVal;
                break;
            case 's':
                results = leftVal - rightVal;
                break;
            case 'd':
                results = leftVal / rightVal;
                break;
            case 'm':
                results = leftVal * rightVal;
                break;
            default:
                System.out.println("Error - invalid opCode");
                results = 0.0d;
                break;
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
