/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
*/

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<int[]>();
        if (nums1.length == 0 || nums2.length == 0) return list;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
           @Override
           public int compare(int[] a, int[] b) {
               return (a[0] + a[1]) - (b[0] + b[1]);
           }
        }); 
        int i1 = k > nums1.length ? nums1.length : k;
        int i2 = k > nums2.length ? nums2.length : k;
        for (int i = 0; i < i1; i++) {
            for (int j = 0; j < i2; j++) {
                queue.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        while (k > 0 && !queue.isEmpty()) {
            int[] result = queue.poll();
            list.add(result);
            k--;
        }
        return list;
    }
}