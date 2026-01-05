package katas.LeetCode;

public class MajorityElement {

    /*
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than (n / 2) times.
    You may assume that the majority element always exists in the array.

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

    Start with a candidate variable and a count.

    Walk through the array:
    If count is 0 → pick current number as candidate.
    If the current number equals candidate → count++.
    Otherwise → count--.
    After one pass, candidate will be the majority element.
    Intuition: every time a non-majority element “cancels” a majority element,
    the majority still survives because it occurs more than half the time.
     */

    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                element = num;
            }

            if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }
}
