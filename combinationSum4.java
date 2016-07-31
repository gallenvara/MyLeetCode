/*
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
*/

public class Solution {
    //DP
    private final int maxSize = 100000;
    public int combinationSum4(int[] nums, int target) {
        int length = nums.length;
        if (target == 0 || length == 0) return 0;
        int[] f = new int[maxSize];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            int sum = 0;
            for (int j = 0; j < length; j++) {
                if (i >= nums[j]) {
                    sum += f[i - nums[j]];
                }
            }
            f[i] = sum;
        }
        return f[target];
    }
}
/*
回溯，当target到达30左右超时；
int length = nums.length;
        if (target == 0) {
            result++;
        }
        for (int i = 0; i < length; i++) {
            if (target - nums[i] >= 0) {
                target -= nums[i];
                combinationSum4(nums, target);
                target += nums[i];
            }
        }
*/