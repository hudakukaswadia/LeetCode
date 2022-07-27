st1.push(root.left);
}
if(root.right != null) {
st1.push(root.right);
}
}
while(!st2.isEmpty()) {
postOrder.add(st2.pop().val);
}
return postOrder;
}
}
```
​
## Iterative Using 1 Stack
​
```
// Time Complexity: O(N)
// Space Complexity: O(N)
​
class Solution {
public List<Integer> postorderTraversal(TreeNode root) {
Stack<TreeNode> st = new Stack<TreeNode>();
List<Integer> postOrder = new ArrayList<Integer>();
if (root == null) {
return postOrder;
}
while(root != null || !st.isEmpty()) {
if (root != null) {
st.push(root);
root = root.left;
} else {
TreeNode temp = st.peek().right;
if (temp == null) {
temp = st.peek();
st.pop();
postOrder.add(temp.val);
while (!st.isEmpty() && temp == st.peek().right) {
temp = st.peek();
st.pop();
postOrder.add(temp.val);
}
} else root = temp;
}
}
return postOrder;
}
}
```