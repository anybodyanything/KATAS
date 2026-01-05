package katas.CodeWars;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MorseDecoder {
    /*
    In this kata you have to write a simple Morse code decoder.

    The Morse code encodes every character as a sequence of "dots" and "dashes":
    For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−−.

    The Morse code is case-insensitive, traditionally capital letters are used.
    When the message is written in Morse code, a single space is used to separate the character codes
    and 3 spaces are used to separate words:
    For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.

    NOTE: Extra spaces before or after the code have no meaning and should be ignored.

    In addition to letters, digits and some punctuation, there are some special service codes,
    the most notorious of those is the international distress signal SOS, that is coded as ···−−−···.
    These special codes are treated as single special characters, and usually are transmitted as separate words.

    Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.
     */

    public String decode(String morseCode) {
        StringBuilder result = new StringBuilder();
        //up to three spaces, as that's the number of spaces that divide the words in Morse Code
        String[] splitCode = morseCode.trim().split(" {3}");

        for (int i = 0; i < splitCode.length; i++){
            //Split letters by space, as that is how letters are spaced
            String[] letters = splitCode[i].split(" ");
            for(String letter : letters){
                result.append(MorseCode.MORSE_CODE.get(letter));
            }
            if(i < splitCode.length - 1){
                result.append(" ");
            }
        }
        return result.toString();
    }

    public class MorseCodeDecoderSimpler {
        public static String decode(String morseCode) {
            String result = "";
            for(String word : morseCode.trim().split("   ")) {
                for(String letter : word.split("\\s+")) {
                    result += MorseCode.MORSE_CODE.get(letter);
                }
                result += ' ';
            }
            return result.trim();
        }
    }

    public String decodeStreams(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(MorseDecoder::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String word) {
        return Arrays.stream(word.split(" ")).map(MorseCode.MORSE_CODE::get).collect(Collectors.joining());
    }

    static class MorseCode {
        public static final Map<String, String> MORSE_CODE = new HashMap<>();

        static {
            // Letters
            MORSE_CODE.put(".-", "A");
            MORSE_CODE.put("-...", "B");
            MORSE_CODE.put("-.-.", "C");
            MORSE_CODE.put("-..", "D");
            MORSE_CODE.put(".", "E");
            MORSE_CODE.put("..-.", "F");
            MORSE_CODE.put("--.", "G");
            MORSE_CODE.put("....", "H");
            MORSE_CODE.put("..", "I");
            MORSE_CODE.put(".---", "J");
            MORSE_CODE.put("-.-", "K");
            MORSE_CODE.put(".-..", "L");
            MORSE_CODE.put("--", "M");
            MORSE_CODE.put("-.", "N");
            MORSE_CODE.put("---", "O");
            MORSE_CODE.put(".--.", "P");
            MORSE_CODE.put("--.-", "Q");
            MORSE_CODE.put(".-.", "R");
            MORSE_CODE.put("...", "S");
            MORSE_CODE.put("-", "T");
            MORSE_CODE.put("..-", "U");
            MORSE_CODE.put("...-", "V");
            MORSE_CODE.put(".--", "W");
            MORSE_CODE.put("-..-", "X");
            MORSE_CODE.put("-.--", "Y");
            MORSE_CODE.put("--..", "Z");

            // Numbers
            MORSE_CODE.put("-----", "0");
            MORSE_CODE.put(".----", "1");
            MORSE_CODE.put("..---", "2");
            MORSE_CODE.put("...--", "3");
            MORSE_CODE.put("....-", "4");
            MORSE_CODE.put(".....", "5");
            MORSE_CODE.put("-....", "6");
            MORSE_CODE.put("--...", "7");
            MORSE_CODE.put("---..", "8");
            MORSE_CODE.put("----.", "9");

            // Common punctuation
            MORSE_CODE.put(".-.-.-", ".");
            MORSE_CODE.put("--..--", ",");
            MORSE_CODE.put("..--..", "?");
            MORSE_CODE.put(".----.", "'");
            MORSE_CODE.put("-.-.--", "!");
            MORSE_CODE.put("-..-.", "/");
            MORSE_CODE.put("-.--.", "(");
            MORSE_CODE.put("-.--.-", ")");
            MORSE_CODE.put(".-...", "&");
            MORSE_CODE.put("---...", ":");
            MORSE_CODE.put("-.-.-.", ";");
            MORSE_CODE.put("-...-", "=");
            MORSE_CODE.put(".-.-.", "+");
            MORSE_CODE.put("-....-", "-");
            MORSE_CODE.put("..--.-", "_");
            MORSE_CODE.put(".-..-.", "\"");
            MORSE_CODE.put("...-..-", "$");
            MORSE_CODE.put(".--.-.", "@");

            // Special SOS
            MORSE_CODE.put("...---...", "SOS");


        }
    }

}
