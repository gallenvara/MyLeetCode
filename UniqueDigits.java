/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
*/

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 9;
            for (int j = 0; j < i - 1; j++) {
                if (9 - j > 0) {
                    sum *=  9 - j;
                }
            }
            f[i] = f[i - 1] + sum;
        }
        return f[n];
    }
}