/*
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int min = 10000;
        int min_index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                min_index = i;
            }
        }
        String prefix = "";
        boolean flag = true;
        for (int j = 0; j < strs[min_index].length(); j++) {
             for (int i = 0; i < strs.length; i++) {
                 if (i == min_index) continue;
                 if (strs[min_index].charAt(j) != strs[i].charAt(j)) {
                     flag = false;
                     break;
                 }
        }
        if (flag) prefix += strs[min_index].charAt(j);
        else break;
    }
    return prefix;
    }
}
