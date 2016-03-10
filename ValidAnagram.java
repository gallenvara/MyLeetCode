/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

/*
这题目是很简单的字母统计问题，但最开始考虑复杂了，原来的想法是将s从下标0开始依次标记i++，然后从t中找与之匹配
的字母并进行去重处理，然后快排一下看两者是否吻合；实际上只要s和t中每个字母出现的次数一样就可以了，可以证明，
一定会经过有限次颠倒变换变为一致。
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if ((s.equals("")) && (t.equals(""))) return true;
        int[] a = new int[30];
        int[] b = new int[30];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            a[((int)ch - 97)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            b[((int)ch - 97)]++;
        }
        for (int i = 0; i < 30; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}