/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arr = new ArrayList<>();
        StringBuilder sB = new StringBuilder();
        if (root == null) {
            return arr;
        }
        getPath(root, arr, sB);
        return arr;
    }
    
    public void getPath(TreeNode root, List<String> arr, StringBuilder res) {
        if (root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            res.append(String.valueOf(root.val));
            arr.add(res.toString());
            return;
        }
        
        String s = res.toString() + String.valueOf(root.val) + "->";
        getPath(root.left, arr, new StringBuilder(s));
        getPath(root.right, arr, new StringBuilder(s));
    }
}