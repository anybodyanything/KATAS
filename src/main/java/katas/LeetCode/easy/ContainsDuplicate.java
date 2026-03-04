package katas.LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    /*
    Given an integer array nums and an integer k, return true if there are two distinct indices i and j
    in the array such that nums[i] == nums[j] and abs(i - j) <= k.

    Example 1:
    Input: nums = [1,2,3,1], k = 3
    Output: true

    Example 2:
    Input: nums = [1,0,1,1], k = 1
    Output: true

    Example 3:
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false
     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(indexes.containsKey(nums[i])){
                int previous = indexes.get(nums[i]);
                if(i - previous <= k){
                    return true;
                }
            }
            indexes.put(nums[i], i);
        }
        return false;
    }

}
