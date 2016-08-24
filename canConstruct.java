/*
 Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length() - 1;
        int len2 = magazine.length();
        int[] flag = new int[10000];
        while (len1 >= 0) {
            boolean boo = false;
            for (int i = 0; i < len2; i++) {
                if (magazine.charAt(i) == ransomNote.charAt(len1) && flag[i] == 0) {
                    flag[i] = 1;
                    boo = true;
                    break;
                }
            }
            if (!boo) {
                return false;
            } else {
                len1--;
            }
        }
        return true;
    }
}