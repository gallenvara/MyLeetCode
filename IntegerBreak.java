/*
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: you may assume that n is not less than 2.
*/

public class Solution {
    public int integerBreak(int n) {
     int result = 1;
     if (n == 2) return 1;
     if (n == 3) return 2;
     while (n > 4) {
         result *= 3;
         n -= 3;
     }
     result *= n;
     return result;
    }
}