package katas.LeetCode;

import java.util.Arrays;

public class RemoveDuplicatesTwo {
    /*
    Given an integer array nums sorted in non-decreasing order,
    remove some duplicates in-place such that each unique element appears at most twice.
    The relative order of the elements should be kept the same.
    Since it is impossible to change the length of the array in some languages,
    you must instead have the result be placed in the first part of the array nums.
    Return k after placing the final result in the first k slots of nums.
     */

    public int removeDuplicates(int[] nums){
        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[k - 2]){
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

}
