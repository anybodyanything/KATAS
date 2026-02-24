package katas.LeetCode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RansomNote {
    /*
    Given two strings ransomNote and magazine, return true if ransomNote can be constructed
    by using the letters from magazine and false otherwise.
    Each letter in magazine can only be used once in ransomNote.

    Example 1:
    Input: ransomNote = "a", magazine = "b"
    Output: false

    Example 2:
    Input: ransomNote = "aa", magazine = "ab"
    Output: false

    Example 3:
    Input: ransomNote = "aa", magazine = "aab"
    Output: true

     */

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char letter :  magazine.toCharArray()) {
            charCount.put(letter, charCount.getOrDefault(letter, 0) + 1);
        }

        for (char letter : ransomNote.toCharArray() ) {
            if(!charCount.containsKey(letter) || charCount.get(letter) == 0){
                return false;
            }
            charCount.put(letter, charCount.get(letter) - 1);
        }

        return true;
    }
}
