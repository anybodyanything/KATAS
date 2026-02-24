package katas.LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    /*
    Given a pattern and a string s, find if s follows the same pattern.
    Here follow means a full match, such that there is a bijection between a
    letter in pattern and a non-empty word in s. Specifically:
    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.

    Example 1:
    Input: pattern = "abba", s = "dog cat cat dog"
    Output: true
    Explanation:
    The bijection can be established as:
    'a' maps to "dog".
    'b' maps to "cat".

    Example 2:
    Input: pattern = "abba", s = "dog cat cat fish"
    Output: false

    Example 3:
    Input: pattern = "aaaa", s = "dog cat cat dog"
    Output: false
     */


    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        String[] stringArray = s.split(" ");

        if(pattern.length() != stringArray.length){
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            String word = stringArray[i];

            if(charToWord.containsKey(letter) && !charToWord.get(letter).equals(word)){
                return false;
            }

            if(wordToChar.containsKey(word) && wordToChar.get(word) != letter){
                return false;
            }

            charToWord.put(letter, word);
            wordToChar.put(word, letter);

        }

        return true;
    }
}
