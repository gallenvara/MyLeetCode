/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        String temp = "";
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                temp += s.charAt(i);
            }
            if (s.charAt(i) == ')') {
                if (temp.length() == 0) return false;
                if (temp.charAt(temp.length() - 1) == '(') {
                    temp = temp.substring(0, temp.length() - 1);
                } 
                else return false;
            }
            if (s.charAt(i) == ']') {
                if (temp.length() == 0) return false;
                if (temp.charAt(temp.length() - 1) == '[') {
                    temp = temp.substring(0, temp.length() - 1);
                } 
                else return false;
            }
            if (s.charAt(i) == '}') {
                if (temp.length() == 0) return false;
                if (temp.charAt(temp.length() - 1) == '{') {
                    temp = temp.substring(0, temp.length() - 1);
                } 
                else return false;
            }
        }
        return temp.length() == 0;
    }
}