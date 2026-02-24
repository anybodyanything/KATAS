package katas.LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    /*
    Given two strings s and t, determine if they are isomorphic.
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while preserving
    the order of characters. No two characters may map to the same character, but a character may map to itself.

    Example 1:
    Input: s = "egg", t = "add"
    Output: true
    Explanation:
    The strings s and t can be made identical by:
    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

    Example 2:
    Input: s = "foo", t = "bar"
    Output: false
    Explanation:
    The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

    Example 3:
    Input: s = "paper", t = "title"
    Output: true
     */


    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            System.out.println("Strings not the same length");
            return false;
        }
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char one = s.charAt(i);
            char two = t.charAt(i);

            if(sToT.containsKey(one) && sToT.get(one) != two){
                return false;
            }

            if(tToS.containsKey(two) && tToS.get(two) != one){
                return false;
            }

            sToT.put(s.charAt(i), t.charAt(i));
            tToS.put(t.charAt(i), s.charAt(i));

        }

        return true;
    }
}
