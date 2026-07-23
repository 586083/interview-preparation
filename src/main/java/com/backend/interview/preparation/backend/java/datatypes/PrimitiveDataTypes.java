package com.backend.interview.preparation.backend.java.datatypes;

public class PrimitiveDataTypes {

    /***
     * primitive data type
     * byte -> 8bit
     * short -> 16bit
     * int -> 32bit
     * long -> 64bit
     * float -> a single-precision 32-bit IEEE 754 floating-point representation
     * double -> double-precision 64-bit IEEE 754 floating-point representation
     * char -> single 16-bit Unicode character
     * boolean -> true ot false
     */

    /**
     * 2power7 -1
     * The byte data type is an 8-bit signed two's complement integer with a minimum value of -128 (-27)
     * and a maximum value of 127 (inclusive) (27 -1).
     */
    public static final byte BYTE_DATA = 100;

    /**
     * The short data type is a 16-bit signed two's complement integer,
     * which provides a range of values from -32,768 (-215) to 32,767 (inclusive) (215 -1).
     * Like the byte data type, the short data type is also beneficial for saving memory,
     * as it occupies less space compared to an integer, being only half the size.
     */
    public static final short SHORT_DATA = 32767;

    /**
     * The int data type is a 32-bit signed two's complement integer,
     * allowing for a wide range of values from -2,147,483,648 (-231) to 2,147,483,647 (inclusive) (231 -1).
     */
    public static final int INT_DATA = 2147483647;

    /**
     * The long data type is a 64-bit signed two's complement integer, capable of representing
     * a vast range of values from -9,223,372,036,854,775,808 (-263) to 9,223,372,036,854,775,807
     * (inclusive) (263 -1). This data type is used when a wider range than int is needed, where its default value is 0L.
     */
    public static final long LONG_DATA= 9223372036854775807L;

    /***
     * The float data type is a single-precision 32-bit IEEE 754 floating-point representation.
     * It is particularly useful for saving memory in large arrays of floating-point numbers.
     * Its default value is 0.0f. However, it's important to note that the float data type is not suitable for precise values,
     * such as currency, due to potential rounding errors in floating-point arithmetic.
     */
    public static final float FLOAT_DATA = 234.5f;

    /**
     *The double data type is a double-precision 64-bit IEEE 754 floating-point representation,
     * which is generally used as the default data type for decimal values,
     * generally the default choice. Double data type should never be used for precise
     * values such as currency, where its default value is 0.0d.
     */
    public static final double DOUBLE_DATA = 234567.6788;

    /**
     * The boolean data type represents a single bit of information and can hold one of two possible values: true or false.
     * This data type is used for simple flags that track true/false conditions where its default value is false.
     */
    public static final boolean BOOLEAN_DATA = true;

    /***
     * The char data type is a single 16-bit Unicode character, which represents a wide range of characters from different languages and symbols.
     * With a range '\u0000' (or 0) to '\uffff' (or 65,535 inclusive).
     * This data type is primarily used to store individual characters.
     */
    public static final char CHAR_DATA = 'A';


}
