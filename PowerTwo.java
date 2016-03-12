/*
Given an integer, write a function to determine if it is a power of two.
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        double k = Math.log(n) / Math.log(2);
        double small = Math.abs((int)(k) - k);
        if ((small < 1e-10)||((1 - small) < 1e-10)) return true;
        return false;
    }
}