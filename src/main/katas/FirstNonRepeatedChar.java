package main.katas;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

    /*
    Write a function named first_non_repeating_letter† that takes a string input,
    and returns the first character that is not repeated anywhere in the string.

    For example, if given the input 'stress', the function should return 't',
    since the letter t only occurs once in the string, and occurs first in the string.

    As an added challenge, upper- and lowercase letters are considered the same character,
    but the function should return the correct case for the initial letter.
    For example, the input 'sTreSS' should return 'T'.

    If a string contains all repeating characters, it should return an empty string ("");
     */

    public String firstNonRepeatingLetter(String s){
        char[] charArray = s.toCharArray();
        Map<Character, Integer> counts = new HashMap<>();

        for (char letter : charArray) {
            char lowerCase = Character.toLowerCase(letter);
            counts.put(lowerCase, counts.getOrDefault(lowerCase, 0) + 1);
        }

        for (char letter : charArray){
            if(counts.get(Character.toLowerCase(letter)) == 1) {
                return String.valueOf(letter);
            }
        }

        return "";
    }

    public static String firstNonRepeatingLetterSimple(String s){
        //se o index deste char em upper / lowercase for igual
        // ao last index dele mesmo, então existe apenas 1

                for (String str : s.split("")) {
            if (s.toUpperCase().indexOf(str.toUpperCase()) == s.toUpperCase().lastIndexOf(str.toUpperCase())) return str;
        }
        return "";
    }

}
