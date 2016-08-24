/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < len1; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < len2; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        Iterator<Integer> iterator = set2.iterator();
        int[] a = new int[set2.size()];
        int index = 0;
        while (iterator.hasNext()) {
            a[index++] = iterator.next();
        }
        return a;
    }
}