/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode[] a = new TreeNode[10000];
    public static int result = 0;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
		TreeNode root_rep = root;
        hasPathSum(root, sum);
        while(result > 0) {
            List<Integer> subList = new ArrayList<>();
            while (a[result - 1] != root_rep) {
                subList.add(a[result - 1].val);
                a[result - 1] = getParent(root_rep, a[result - 1]);
            }
            subList.add(root.val);
            list.add(changeOrderOfList(subList));
            result--;
        }
        return list;
    }
    
    public List<Integer> changeOrderOfList(List<Integer> list) {
        List<Integer> list_temp = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            list_temp.add(list.get(i));
        }
        return list_temp;
    }
    
    public TreeNode getParent(TreeNode root, TreeNode node) {
        TreeNode lh = null;
        TreeNode rh = null;
        if (null == root)
            return null;
        if (root.left == node || root.right == node)
            return root;
        lh = getParent(root.left, node);
        rh = getParent(root.right, node);
        return lh != null ? lh : rh;
    }
    
     public boolean hasPathSum(TreeNode root, int sum) {
        boolean boo1 = false;
        boolean boo2 = false;
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                a[result++] = root;
                return true;
            }
        } 
        if (root.left != null) {
            boo1 = hasPathSum(root.left, sum - root.val);
        } 
        if (root.right != null) {
            boo2 = hasPathSum(root.right, sum - root.val);
        }
        return false;
    }
}
