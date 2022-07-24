List<Integer> inorder = new ArrayList<Integer>();
node = stack.pop();
inorder.add(node.val);
node = node.right;
}
}
return inorder;
}
}
```
​
## Recursive Inorder Traversal
​
```
// Time complexity: O(N)
// Space complexity: O(N)
​
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
```