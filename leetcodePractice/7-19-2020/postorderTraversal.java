/**
 * 二叉树非递归后续遍历--》也需要借助栈完成，遍历顺序是左、右、根
 * 大致思路如下：
 * 1. 如果根节点非空， 将跟节点加入到栈中
 * 2. 如果栈不空， 取栈顶元素（暂时不弹出）
 *      a. 如果（左子树已访问过或者左子树为空）， 且（右子树已访问过或者右子树为空），则弹出栈顶节点，将其值加入数组
 *      b. 如果左子树不为空，且未访问过，则将左子节点加入栈中，并标左子树已访问过
 *      c. 如果右子树不为空，且未访问过，则将右子节点加入栈中，并标右子树已访问过
 * 3. 重复第二步， 直到栈空
 */
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null; // previously traversed node
    TreeNode curr = root;
    if (root == null) {
        return result;
    }

    stack.push(root);
    while (!stack.empty()) {
        curr = stack.peek();
        if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
            if (curr.left != null) {
                stack.push(curr.left);
            } else if (curr.right != null) {
                stack.push(curr.right);
            }
        } else if (curr.left == prev) { // traverse up the tree from the left
            if (curr.right != null) {
                stack.push(curr.right);
            }
        } else { // traverse up the tree from the right
            result.add(curr.val);
            stack.pop();
        }
        prev = curr;
    }
    return result;
}
