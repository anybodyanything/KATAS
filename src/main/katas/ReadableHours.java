package main.katas;

public class ReadableHours {
    /*
    Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

    HH = hours, padded to 2 digits, range: 00 - 99
    MM = minutes, padded to 2 digits, range: 00 - 59
    SS = seconds, padded to 2 digits, range: 00 - 59
    The maximum time never exceeds 359999 (99:59:59)
    Ex:
    makeReadable(86399) = "23:59:59";
    makeReadable(359999) = "99:59:59";
     */


    public String makeReadable(int seconds) {
        // seconds to hours
        int hours = seconds / 3600;

        //remainder of seconds to minutes, remainder removes the hours
        int minutes = (seconds % 3600) / 60;

        //number of seconds
        int secs = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    public  String makeReadableTwo(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }
}
