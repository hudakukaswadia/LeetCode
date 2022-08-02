## Solution: Recursive
​
```
// Time Complexity: O(N)
// Space Compelexity: O(N)
​
class Solution {
TreeNode prev = null;
public void flatten(TreeNode root) {
if (root == null) {
return;
}
flatten(root.right);
flatten(root.left);
root.right = prev;
root.left = null;
prev = root;
}
}
```