/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

public class Solution {
    public boolean isHappy(int n) {
        int count = 0;
        while (true) {
            if (n == 1) 
            {
                return true;
            } else {
                n = divide(n);
                count++;
            }
            if (count > 100) break;
        }
        return false;
    }
    public int divide(int n) {
        int[] number = new int[10];
        int count = 0;
        while (n > 0) {
            number[count++] = n % 10;
            n = n / 10;
        }
        int sum = 0;
        for (int i = 0; i < count; i++){
            sum += number[i] * number[i];
        }
        return sum;
    }
}