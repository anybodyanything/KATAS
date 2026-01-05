package katas.CodeWars;

public class SnailSort {

    /*
    Given an n x n array, return the array elements arranged from outermost
    elements to the middle element, traveling clockwise.
    array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
    snail(array) #=> [1,2,3,6,9,8,7,4,5]

    For better understanding, please follow the numbers of the next array consecutively:
     array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
    snail(array) #=> [1,2,3,4,5,6,7,8,9]
     */


    public int[] snail(int[][] array) {
        if (array.length == 0) return new int[0];
        int resultSize = 0;
        for (int[] row : array) {
            resultSize += row.length;
            
        }
        int[] result = new int[resultSize];
        int index = 0;
        //control variable (boundaries)
        int top = 0;
        int bottom = array.length - 1;
        int left = 0;
        int right = array[0].length - 1;

        while (top <= bottom && left <= right) {
            //process first row
            //while index (starts on the left is inferior to right (last index of row,
            // calculated this way because it's a square [][]
            for (int i = left; i <= right; i++) {
                //left is 0, right is 2, runs three times
                //i starts with the value of left, but is updated in each loop
                result[index++] = array[top][i];
            }
            top ++;

            //process second row, right side
            //while index starts on the left is inferior to right (last index of row),
            //calculated this way because it's a square [][]
            for (int j = top; j <= bottom; j++) {
                result[index++] = array[j][right];
            }
            right--;

            //process bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[index++] = array[bottom][i];
                }
                bottom--;
            }

            //process left row
            if (left <= right) {
                for (int i = bottom; i >= top ; i--) {
                    result[index++] = array[i][left];
                }
                left++;
            }
        }

        return result;
    }
}
