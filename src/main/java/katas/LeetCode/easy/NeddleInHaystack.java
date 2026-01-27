package katas.LeetCode.easy;

public class NeddleInHaystack {

    /*
    Given two strings needle and haystack,
    return the index of the first occurrence of needle in haystack,
    or -1 if needle is not part of haystack.


Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
    para j de 0 até haystack.length - needle.length
    para k de 0 até needle.length
        se haystack[j + k] != needle[k]
            parar comparação
    se todas iguais
        devolver j

     */

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}