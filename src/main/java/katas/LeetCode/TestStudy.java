package katas.LeetCode;

import java.sql.PreparedStatement;
import java.util.Arrays;

public class TestStudy {

    /*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates
    in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
    Consider the number of unique elements in nums to be k.
    After removing duplicates, return the number of unique elements k.
    The first k elements of nums should contain the unique numbers in sorted order.
    The remaining elements beyond index k - 1 can be ignored.

     */

    public int removeDuplicates(int[] nums){
        //o primeiro indíce é sempre válido, mesmo que removido o seu duplicado
        int result = 1;

        //se o index 0 já está tratado, o i começa em 1
        //e é comparado com o result - 1 (o indíce anterior)
        for (int i = 1; i < nums.length; i++) {
            //se forem diferentes: o indíce de result é substituido pelo valor de i
            if (nums[i] != nums[result - 1]){
                //se os valores forem sempre iguais, nunca são substituidos
                //e o i e result terão sempre o mesmo valor
                //de outra forma, o i passa a ter 1 valor mais que result
                nums[result] = nums[i];
                result++;
            }

        }

        return result;
    }

    /*
    Given an integer array nums and an integer val, remove all occurrences
    of val in nums in-place (modifies the input itself, without creating a copy).
    The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

    Consider the number of elements in nums which are not equal to val be k,
    to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the
    elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
    Return k.*/

    public int removeElement(int[] nums, int val){
        //aqui result começa a 0 pois poderão NÃO existir elementos == val
        int result = 0;
        int lenghtControl = nums.length;

        while (lenghtControl > result){
            if(nums[result] == val){
                nums[result] = nums[lenghtControl - 1];
                lenghtControl--;
            } else {
                result++;
            }
        }

        return result;
    }
}
