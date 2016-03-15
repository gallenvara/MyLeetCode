/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] f = new int[10000];
        f[0] = 0;
        f[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            f[i] = max(f[i - 2] + nums[i - 1], f[i - 1]);
        }
        return f[nums.length];
    }
    public int max(int x, int y) {
        return x > y ? x : y;
    }
}