/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.
*/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] f = new int[50000];
        f[0] = 1;
        for (int i = 1; i < length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(f[j], max);
                }
            }
            f[i] = max + 1;
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (max < f[i]) {
                max = f[i];
            }
        }
        return max;
    }
}