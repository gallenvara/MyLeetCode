/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null){
            return res;
        }
        getPaths (root, "", res);
        return res;
    }

    public void getPaths(TreeNode root, String str, List<String> res){
        if (str.equals("")){
            str += root.val;
        }
        else {
            str += "->"+root.val;
        }
        if (root.left == null && root.right == null){
            res.add (str);
            return;
        }
        if (root.left != null){
            getPaths(root.left, str, res);
        }
        if (root.right != null){
            getPaths(root.right, str, res);
        }
    }
}