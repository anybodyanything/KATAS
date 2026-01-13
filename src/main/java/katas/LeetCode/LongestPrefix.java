package katas.LeetCode;

public class LongestPrefix {
    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
     */

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        StringBuilder sb = new StringBuilder().append(prefix);
        int index = 0;
        for (String word : strs) {
            if(index < 1){
                index++;
            }
            while (!word.startsWith(sb.toString())){
                sb.setLength(sb.length() - 1);
            }
        }

        return sb.toString();
    }



}
