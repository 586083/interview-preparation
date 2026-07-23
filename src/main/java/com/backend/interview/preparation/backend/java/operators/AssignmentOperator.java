package com.backend.interview.preparation.backend.java.operators;

public class AssignmentOperator {

    public static void Operators() {
        int a = 10;
        int b = 20;
        int c = 0;

        c = a + b;
        System.out.println("c = a + b = " + c );

        //c= c+a
        c += a ;
        System.out.println("c += a  = " + c );
        //c = c-a
        c -= a ;
        System.out.println("c -= a = " + c );
        //c = c*a
        c *= a ;
        System.out.println("c *= a = " + c );
        //c = c/a
        c /=a;
        System.out.println("c /= a = " + c );
        //c = c % a
        c %= a;
        System.out.println("c %= a = " + c );
    }

    public static void ShiftOperators() {
        int a = 10;
        int c = 0;

        c <<= 2 ;
        System.out.println("c <<= 2 = " + c );

        c = 15;
        c >>= 2 ;
        System.out.println("c >>= 2 = " + c );

        int x = 5; // Binary: 0000 0101
        int y = x << 2; // Shifts left by 2 bits. Result: 20 (0001 0100)

        int x1 = 20; // Binary: 0001 0100
        int y1 = x1 >> 2; // Shifts right by 2 bits. Result: 5 (0000 0101)
    }

    /**
     * 12 in Binary:  1 1 0 0
     *  1 in Binary:  0 0 0 1
     *  ---------------------
     *  Bitwise AND:  0 0 0 0  -> (Result is 0, so it is Even)
     *
     *  7 in Binary:   0 1 1 1
     *  1 in Binary:   0 0 0 1
     * ---------------------
     * Bitwise AND:   0 0 0 1  -> (Result is 1, so it is Odd)
     *
     * @param num
     */
    public static void checkEvenOdd(int num) {
        // Bitwise AND operation
        if ((num & 1) == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }
    }

    public static void BitwiseOperators() {
        int a = 10;
        int c = 15;

        c ^= a ;
        System.out.println("c ^= a   = " + c );

        c |= a ;
        System.out.println("c |= a   = " + c );
    }
}
