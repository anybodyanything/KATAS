package katas.CodeWars;

public class DigitalRoot {

    /*
    Digital root is the recursive sum of all the digits in a number.
    Given n, take the sum of the digits of n. If that value has more than one digit,
    continue reducing in this way until a single-digit number is produced.
    The input will be a non-negative integer.


    16  -->  1 + 6 = 7
    942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
    132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
    493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
     */

    public int digitalRoot(int n) {
        n = Math.abs(n);
        int result = 0;

        while (n > 0) {
            result += n % 10;
            n /= 10;
        }

        while (result >= 10) {
            int one = result % 10;
            int two = result / 10;
            result = one + two;
        }

        return result;
    }

    public int digitalRootInnerWhile(int n) {
        n = Math.abs(n);

        while (n >= 10) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }

            n = sum;
        }

        return n;
    }

}
