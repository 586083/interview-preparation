package com.backend.interview.preparation.backend.java.operators;

import com.backend.interview.preparation.backend.java.datatypes.PrimitiveDataTypes;

public class ArithmeticOperators {

    /**
     * byte>short>char>int>long>float>double --> type casting hierarchy
     */
    public static void addition() {
        double result = PrimitiveDataTypes.INT_DATA + PrimitiveDataTypes.INT_DATA;
        System.out.println(result);
        System.out.println(PrimitiveDataTypes.INT_DATA + PrimitiveDataTypes.CHAR_DATA);
        System.out.println(PrimitiveDataTypes.INT_DATA + PrimitiveDataTypes.BYTE_DATA);
        System.out.println(PrimitiveDataTypes.INT_DATA + PrimitiveDataTypes.SHORT_DATA);
        System.out.println(PrimitiveDataTypes.INT_DATA + PrimitiveDataTypes.LONG_DATA);
        System.out.println(PrimitiveDataTypes.DOUBLE_DATA + PrimitiveDataTypes.FLOAT_DATA);
    }

    /**
     * 	Returns the remainder of the division.
     * @param args
     */
    public static void modulus(String args[]) {
        int a = 10;
        int b = 20;
        int c = 25;
        System.out.println("b % a = " + (b % a) );
        System.out.println("c % a = " + (c % a) );
    }

    /**
     * Increases the value of a variable by 1.
     * Decreases the value of a variable by 1.
     */
    public static void incrementDecrement(String args[]) {
        int a = 10;
        int d = 25;

        System.out.println("a++   = " +  (a++) );
        System.out.println("a--   = " + (a--) );

        // Check the difference in d++ and ++d
        System.out.println("d++   = " +  (d++) );
        System.out.println("++d   = " +  (++d) );

        int x = 5;
        int y = ++x; // x becomes 6, then y becomes 6

        int a1 = 5;
        int b1 = a1++; // b1 becomes 5, then a1 becomes 6

        System.out.println("x"+y);
        System.out.println("y"+y);
        System.out.println("a1"+a1);
        System.out.println("b1"+b1);
    }
}
