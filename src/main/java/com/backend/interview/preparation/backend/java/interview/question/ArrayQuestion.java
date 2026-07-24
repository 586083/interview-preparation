package com.backend.interview.preparation.backend.java.interview.question;

import java.util.HashMap;

public class ArrayQuestion {

    /**
     * Problem: Reverse the elements of an array without allocating extra space for another array.
     * Pattern: Two-Pointer Strategy (swapping elements from both ends toward the center).
     * Complexity: Time: O(N) | Space: O(1).
     */
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /***
     * Move all 0s to the end of the array while maintaining the relative order of non-zero elements.
     * Read/Write Pointer tracking.
     * Complexity: Time: O(N) | Space: O(1)
     */
    public static void moveZeroes(int[] nums) {
        int writePointer = 0;
        // Shift all non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writePointer] = nums[i];
                writePointer++;
            }
        }
        // Fill the remaining positions with zeroes
        while (writePointer < nums.length) {
            nums[writePointer++] = 0;
        }
    }

    /***
     * Problem: Given an array of integers and a target, return the indices of the two numbers that add up to that target.
     * Pattern: Complement lookup using a HashMap.
     * Complexity: Time: O(N) | Space: O(N).
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {}; // Return empty if no solution
    }

    /***
     * Problem: Rotate an array to the right by k steps, where k is non-negative.
     * Pattern: Array Reversal Trick (Reverse all, reverse first k, reverse remaining).
     * Complexity: Time: O(N) | Space: O(1).
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length; // Handle k larger than array size
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
