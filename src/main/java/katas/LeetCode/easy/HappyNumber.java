package katas.LeetCode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    /*
    Write an algorithm to determine if a number n is happy.
    A happy number is a number defined by the following process:
    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay),
    or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.

    Example 1:
    Input: n = 19
    Output: true
    Explanation:
    1*1 + 9*9 = 82
    8*8 + 2*2 = 68
    6*6 + 8*8 = 100
    1*1 + 0*0 + 0*0 = 1

    Example 2:
    Input: n = 2
    Output: false
     */

    public boolean isHappy(int n){

        Set<Integer> visited = new HashSet<>();

        while (n != 1) {
            visited.add(n);
            n = squareDigits(n);
            if(visited.contains(n)){
                return false;
            }
        }

        return true;
    }

    public int squareDigits(int number){
        int result = 0;

        while (number >= 1){
            result += (number % 10) * (number % 10);
            number /= 10;
        }
        return result;
    }
}
