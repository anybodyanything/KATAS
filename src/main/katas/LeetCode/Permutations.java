package main.katas.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    /*
    In this kata, your task is to create all permutations of a non-empty input string and remove duplicates, if present.

    Create as many "shufflings" as you can!

    Examples:
    With input 'a':
    Your function should return: ['a']

    With input 'ab':
    Your function should return ['ab', 'ba']

    With input 'abc':
    Your function should return ['abc','acb','bac','bca','cab','cba']

    With input 'aabb':
    Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']
     */

    public List<String> singlePermutations(String s) {

        if(s.isEmpty()){
            throw new IllegalArgumentException("Input cannot be empty!");
        }

        List<String> permutations = new ArrayList<>();

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        boolean[] hasBeenUsed = new boolean[s.length()];

        backtrack(charArray, hasBeenUsed, new StringBuilder(), permutations);

        return permutations;
    }

    private static void backtrack(char[] charArray, boolean[] hasBeenUsed,
                                  StringBuilder stringToAdd, List<String> result){
        if (stringToAdd.length() == charArray.length) {
            result.add(stringToAdd.toString());
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (hasBeenUsed[i]){
                continue;
            }

            if(i > 0 && charArray[i] == charArray[i - 1] && !hasBeenUsed[i - 1]) {
                continue;
            }

            stringToAdd.append(charArray[i]);
            hasBeenUsed[i] = true;

            backtrack(charArray, hasBeenUsed, stringToAdd, result);

            stringToAdd.deleteCharAt(stringToAdd.length() - 1);
            hasBeenUsed[i] = false;
        }

    }
}
