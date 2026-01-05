package katas.CodeWars;

public class TwoSum {
    /*
    Given an array of integers and an integer target, return indices of the two numbers that add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]

    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:
    2 <= nums.length <= 10power4 (ie, if array lenght is inferior to 2 or superior to 10.000)
    -109 <= nums[i] <= 10power9 (ie, if any index of the array is inferior to -109 or superior to 1.000.000.000)
    -109 <= target <= 10power9 (ie, if target is inferior to -109 or superior to 1.000.000.000)
    Only one valid answer exists.

     */


    public int[] twoSum(int[] nums, int target) {
        int million = 1000000000;
        int negativeMillion = -1000000000;
        int thousand = 1000;

        if (target < negativeMillion || target > million){
            return new int[0];
        }

        if (nums.length < 2 || nums.length > thousand){
            return new int[0];
        }

        for (int number : nums) {
            if (number < negativeMillion || number > million){
                return new int[0];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j} ;
                }
            }
        }
        return new int[0];
    }
}
