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

// Time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public static void inOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }
}