package main.katas;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatin {

    /*
    Move the first letter of each word to the end of it, then add "ay" to the end of the word.
    Leave punctuation marks untouched.

    pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
    pigIt('Hello world !');     // elloHay orldway !

     */

    public String pigIt(String str) {
        StringBuilder result = new StringBuilder();
        String[] strings = str.split(" ");

        for (int j = 0; j < strings.length; j++) {
            if(!strings[j].matches("[a-zA-Z]+")){
                result.append(strings[j]);
            } else {
                result.append(strings[j].substring(1))
                        .append(strings[j].charAt(0))
                        .append("ay");
            }

            if(j != strings.length -1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public String pigItStreams(String str){
        //create a string array splitting words by " "
        return Arrays.stream(str.split(" "))
        //if the words contains only letters, create a substring removing the first letter,
                // adding it to the end and then adding "ay" to it
                //else, just keep it as it is
        .map(word -> word.matches("[a-zA-Z]+") ? word.substring(1) + word.charAt(0) + "ay" : word)
        //finally, collect them all with a " " - this only adds a space in between tokens,
                //not before the first or after the last
        .collect(Collectors.joining(" "));
    }
}
