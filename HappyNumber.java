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