package main.katas;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesCounter {
    /*
    Write a function that will return the count of distinct case-insensitive alphabetic characters
    and numeric digits that occur more than once in the input string.
    The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

    Example
    "abcde" -> 0 # no characters repeats more than once
    "aabbcde" -> 2 # 'a' and 'b'
    "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
    "indivisibility" -> 1 # 'i' occurs six times
    "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
    "aA11" -> 2 # 'a' and '1'
    "ABBA" -> 2 # 'A' and 'B' each occur twice
     */

    public int duplicateCount(String text) {
        text = text.toLowerCase();
        List<String> duplicates = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            String one = String.valueOf(text.charAt(i));
            for (int j = i+1; j < text.length(); j++) {
                String two = String.valueOf(text.charAt(j));
                if (one.equals(two)) {
                    if (!duplicates.contains(one)){
                        duplicates.add(String.valueOf(text.charAt(i)));
                    }
                }
            }

        }
        return duplicates.size();
    }

    public int duplicateCountStream(String text) {
        return text.toLowerCase()
                .chars()        //create stream of char tokens
                .mapToObj(c -> (char) c)    //map each to object Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())) // map each char to its count
                .values()   //get the counts (remember, it's a Map<>)
                .stream()  //the stream() is needed since collect() finishes the first stream "pipeline's" transformation
                .filter(count -> count > 1) //count only duplicates
                .toList().size(); //get them in a list (the counts of duplicate values), and return its size
    }

    public int duplicateCountIndexing(String text){
        byte[] charsCnt = new byte[255];
        int counter = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            //charsCnt[c] uses the ASCII numeric value to indirectly compare with the byte[] index of said char
            //After value hits 3 (meaning: “we already know it's a duplicate”), no more increments are needed.
            if(charsCnt[c]<3)
                charsCnt[c]++;
            if (charsCnt[c] == 2)
                counter++;
        }
        return counter;
    }
}
