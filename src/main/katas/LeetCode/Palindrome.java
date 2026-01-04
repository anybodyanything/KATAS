package main.katas.LeetCode;

public class Palindrome {

    public boolean isPalindrome(String s) {

        if (s.length() < 1 || s.length() >= 2 * (int) Math.pow(10, 5)) {
            return false;
        }
        String toCheck = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reverse = new StringBuilder(toCheck).reverse().toString();

        return toCheck.equals(reverse);
    }

    public boolean isPalindromeLighter(String s) {

        if (s.length() < 1 || s.length() >= intPower(10, 5)) {
            return false;
        }
        String toCheck = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reverse = new StringBuilder(toCheck).reverse().toString();

        return toCheck.equals(reverse);
    }

    public long intPower(long base, int exponent){
        int result = 1;
        while (exponent > 0 ){
            if(exponent % 2 == 1) {
                result *= base;
            }
            base *= base;
            exponent /= 2;

        }

        return result;
    }


}
