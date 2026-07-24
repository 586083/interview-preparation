package com.backend.interview.preparation.backend.java.question;

import com.backend.interview.preparation.backend.java.interview.question.ArrayQuestion;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayQuestionTest {

    ArrayQuestion arrayQuestion = new ArrayQuestion();

    @Test
    public void reverseTest() {
        int[] arr = {3,2,1};
        arrayQuestion.reverse(arr, 0 , arr.length-1);
        System.out.println("Reversed Array"+ Arrays.toString(arr));
        int[] arr1 = {8,5,3,1,4};
        arrayQuestion.reverse(arr1, 0 , arr.length-1);
        System.out.println("Reversed Array"+ Arrays.toString(arr1));
    }

    @Test
    public void moveZeroesTest() {
        int[] arr2 = {8,0,0,1,0};
        arrayQuestion.moveZeroes(arr2);
        System.out.println("moveZeroesTest"+ Arrays.toString(arr2));
    }

    @Test
    public void twoSumTest() {
        //int[] arr3 = {8,1,3,4,5};
        //System.out.println("twoSumTest"+ Arrays.toString(arrayQuestion.twoSum(arr3,7)));
        int[] arr4 = {8,1,3,4,5};
        System.out.println("twoSumTest"+ Arrays.toString(arrayQuestion.twoSum(arr4,2)));
    }

    @Test
    public void rotateTest() {
        int[] arr4 = {1,2,3,4,5};
        arrayQuestion.rotate(arr4,3);
        System.out.println("rotateTest"+ Arrays.toString(arr4));
    }
}
