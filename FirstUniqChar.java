/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

public class Solution {
    public int firstUniqChar(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            boolean boo = true;
            for (int j = 0; j < length; j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    boo = false;
                    break;
                }
            }
            if (boo) return i;
        }
        return -1;
    }
}