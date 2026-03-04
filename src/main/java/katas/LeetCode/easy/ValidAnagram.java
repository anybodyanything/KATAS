package katas.LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidAnagram {

    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false
     */

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        List<Character> first = new ArrayList<>();
        List<Character> second = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            first.add(s.charAt(i));
            second.add(t.charAt(i));
        }

        Collections.sort(first);
        Collections.sort(second);

        return first.equals(second);
    }

    public boolean isAnagramLight(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        System.out.println(Arrays.toString(count));

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        System.out.println(Arrays.toString(count));

        return true;
    }

}
