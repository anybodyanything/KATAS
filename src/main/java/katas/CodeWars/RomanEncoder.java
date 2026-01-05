package katas.CodeWars;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanEncoder {
    /*
    Create a function taking a positive integer between 1 and 3999 (both included) as its parameter and returning
    a string containing the Roman Numeral representation of that integer.
    Modern Roman numerals are written by expressing each digit separately starting with the leftmost digit and
    skipping any digit with a value of zero. There cannot be more than 3 identical symbols in a row.

     Symbol    Value
        I          1
        V          5
        X          10
        L          50
        C          100
        D          500
        M          1,000

     */

    private Map<Integer, String> mapping = new HashMap<>();

    public RomanEncoder(){
        mapping.put(1, "I");
        mapping.put(5, "V");
        mapping.put(10, "X");
        mapping.put(50, "L");
        mapping.put(100, "C");
        mapping.put(500, "D");
        mapping.put(1000, "M");
    }


    public String solution(int n) {
        StringBuilder result = new StringBuilder();
        int controlNumber = n;

        while (controlNumber >= 1) {
            //Thousands
            if (controlNumber >= 1000){
                result.append(mapping.get(1000));
                controlNumber -= 1000;
            }
            //Hundreds
            else if (controlNumber >= 900) {
                result.append(mapping.get(100));
                result.append(mapping.get(1000));
                controlNumber -= 900;
            } else if (controlNumber >= 500) {
                result.append(mapping.get(500));
                controlNumber -= 500;
            } else if (controlNumber >= 400) {
                result.append(mapping.get(100));
                result.append(mapping.get(500));
                controlNumber -= 400;
            } else if (controlNumber >= 100) {
                result.append(mapping.get(100));
                controlNumber -= 100;
            }

            //Tens
            else if (controlNumber >= 90) {
                result.append(mapping.get(10));
                result.append(mapping.get(100));
                controlNumber -= 90;
            } else if (controlNumber >= 50) {
                result.append(mapping.get(50));
                controlNumber -= 50;
            } else if (controlNumber >= 40) {
                result.append(mapping.get(10));
                result.append(mapping.get(50));
                controlNumber -= 40;
            } else if (controlNumber >= 10){
                result.append(mapping.get(10));
                controlNumber -= 10;
            }

            //Ones
            else if (controlNumber == 9) {
                result.append(mapping.get(1));
                result.append(mapping.get(10));
                controlNumber -= 9;
            } else if (controlNumber >= 5) {
                result.append(mapping.get(5));
                controlNumber -= 5;
            } else if (controlNumber == 4) {
                result.append(mapping.get(1));
                result.append(mapping.get(5));
                controlNumber -= 4;
            } else {
                result.append(mapping.get(1));
                controlNumber -= 1;
            }

        }

        return result.toString();
    }

    private static TreeMap<Integer, String> MAP;

    static {
        MAP = new TreeMap<Integer, String>(Collections.reverseOrder());
        MAP.put( 1, "I" );
        MAP.put( 4, "IV" );
        MAP.put( 5, "V" );
        MAP.put( 9, "IX" );
        MAP.put( 10, "X" );
        MAP.put( 40, "XL" );
        MAP.put( 50, "L" );
        MAP.put( 90, "XC" );
        MAP.put( 100, "C" );
        MAP.put( 400, "CD" );
        MAP.put( 500, "D" );
        MAP.put( 900, "CM" );
        MAP.put( 1000, "M" );
    }

    public String solutionBestPractice(int n) {
        StringBuilder builder = new StringBuilder();
        //for every entry in MAP
        for( Map.Entry<Integer, String> entry: MAP.entrySet() ){
            //get the key (reversed, so starts in the thousands)
            int i = entry.getKey();
            //and its value
            String s = entry.getValue();
            while( n>=i ){
                //append the value to the builder
                builder.append(s);
                //reduce the number by the same value of the key
                //i.e., if 3999, reduce by 1000
                n -= i;
            }
        }
        System.out.println(MAP.toString());
        return builder.toString();
    }


}
