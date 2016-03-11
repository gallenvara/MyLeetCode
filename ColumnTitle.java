/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class Solution {
    public String convertToTitle(int n) {
        String s = "";
        int index = 0;
        int[] a = new int[50000];
        while (n > 0) {
            a[index] = n % 26 == 0 ? 26 : n % 26;
            n = (n - a[index]) / 26;
            index++;
        }
        for (int i = 0;i < index; i++) {
            s += (char)(a[index - i - 1] + 64);
        }
        return s;
    }
}