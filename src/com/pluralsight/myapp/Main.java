package com.pluralsight.myapp;

import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathEquation;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.PowerOf;
import com.pluralsight.calcengine.Subtractor;

public class Main {

    public static void main (String[] args) {

        // useMathEquations();
        // useInheritance();
        // useCalculateHelper();

        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
            new Adder(),
            new PowerOf()
        });

        for (String statement: statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }

    }

    static void useCaculateHelper() {
        String[] statements = {
                "add 1.0",           // Error: incorrect number of values
                "add xx 25.0",       // Error: non-numeric data
                "addX 0.0 0.0",      // Error: invalid command
                "divide 100.0 50.0", // 100.0 / 50.0 = 2.0
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "mutltiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement: statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch(InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null) {
                    System.out.println(" Original Exception: " + e.getCause().getMessage());
                }
            }
        }

    }

    static void useInheritance() {

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtractor(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for (CalculateBase calculator : calculators) {
            calculator.calculate();
            System.out.print("results=");
            System.out.println(calculator.getResults());
        }

    }

    static void useMathEquations() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0);
        equations[1] = new MathEquation('a', 25.0d, 92.0);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation: equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResults());
        }

        System.out.println();
        System.out.println("Using overloading");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result= ");
        System.out.println(equationOverload.getResults());

    }


/*
    public static com.pluralsight.calcengine.MathEquation create(double leftVal, double rightVal, char opCode) {
        com.pluralsight.calcengine.MathEquation equation = new com.pluralsight.calcengine.MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        return equation;
    }
*/
}
