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

// Time Complexity: O(N)
// Space Complexity: O(N)

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         Stack<TreeNode> st = new Stack<TreeNode>();
//         List<Integer> postOrder = new ArrayList<Integer>();
        
//         if (root == null) {
//             return postOrder;
//         }
        
//         while(root != null || !st.isEmpty()) {
            
//             if (root != null) {
//                 st.push(root);
//                 root = root.left;
//             } else {
//                 TreeNode temp = st.peek().right;
//                 if (temp == null) {
//                     temp = st.peek();
//                     st.pop();
//                     postOrder.add(temp.val);
//                     while (!st.isEmpty() && temp == st.peek().right) {
//                         temp = st.peek();
//                         st.pop();
//                         postOrder.add(temp.val);
//                     }
//                 } else root = temp;
//             }
//         }
//         return postOrder;
//     }
// }

// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public static void postOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }
}