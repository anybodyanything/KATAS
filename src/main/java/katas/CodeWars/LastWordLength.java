package katas.CodeWars;

public class LastWordLength {

    /*
    Given a string s consisting of words and spaces, return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only.
    Example 1:
    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.

    Example 2:
    Input: s = "   fly me   to   the moon  "
    Output: 4
    Explanation: The last word is "moon" with length 4.
     */

    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");

        return array[array.length - 1].length();
    }

    //O(1) solution: only two ints instead of as many chars as the input
    public int lengthOfLastWordOptimized(String s) {
        int len = 0;
        int i = s.length() - 1;

        // skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // count last word
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
            System.out.println("Count last word" + s);
        }

        return len;
    }

}
