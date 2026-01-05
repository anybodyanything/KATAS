package katas.CodeWars;

public class ROT13 {

    /*
    How can you tell an extrovert from an introvert at NSA?
    Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.

    I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
    According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.

    For this task you're only supposed to substitute characters. Not spaces, punctuation, numbers, etc.

    Test examples:
    "EBG13 rknzcyr." -> "ROT13 example."

    "This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"
     */

    public String rot13(String message) {
        char[] chars = message.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char aChar : chars) {
            if (aChar >= 'A' && aChar <= 'Z'){
                result.append((char) ('A' + (aChar - 'A' + 13) % 26));
            } else if (aChar >= 'a' && aChar <= 'z'){
                result.append((char) ('a' + (aChar - 'a' + 13) % 26));
            } else {
                result.append(aChar);
            }
        }

        return result.toString();
    }


}
