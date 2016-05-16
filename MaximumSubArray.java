/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i-1] + nums[i], nums[i]);
        }
        int max = - Integer.MAX_VALUE;
        for (int i = 0; i < f.length; i++) {
            if (max < f[i]) {
                max = f[i];
            }
        }
        return max;
    }
}