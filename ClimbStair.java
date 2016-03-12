/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class Solution {
    public int climbStairs(int n) {
        double x1 = (1 + Math.sqrt(5)) / 2;
        double x2 = (1 - Math.sqrt(5)) / 2;
        double c = 1 / Math.sqrt(5);
        double xx1 = 1;
        double xx2 = 1;
        for (int i = 0; i <= n; i++) {
            xx1 *= x1;
            xx2 *= x2;
        }
        return (int)(c * (xx1 - xx2));
    }
}