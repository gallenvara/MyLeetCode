/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];
        f[0] = nums[0];
        g[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
            f[i] = Math.max(f[i-1] * nums[i], nums[i]);
            g[i] = Math.min(g[i-1] * nums[i], nums[i]);
            } else {
                f[i] = Math.max(g[i-1] * nums[i], nums[i]);
                g[i] = Math.min(f[i-1] * nums[i], nums[i]);
            }
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