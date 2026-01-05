package katas.CodeWars;

public class DashToCamel {

    /*
    Complete the method/function so that it converts dash/underscore delimited words into camel casing.
    The first word within the output should be capitalized only if the original word was capitalized
    (known as Upper Camel Case, also often referred to as Pascal case).
    The next words should be always capitalized.
     */

    public String toCamelCase(final String toModify) {
        StringBuilder result = new StringBuilder(toModify);

        for (int i = 0; i < result.length(); i++) {
            char toCheck = result.charAt(i);
            if(toCheck == '-' || toCheck == '_'){
                //upperCase next char if it exists
                if(i + 1 < result.length()) {
                    result.setCharAt(i + 1, Character.toUpperCase(result.charAt(i + 1)));
                }
                //remove the - or _
                result.deleteCharAt(i);
            }
        }
        return result.toString();
    }
}
