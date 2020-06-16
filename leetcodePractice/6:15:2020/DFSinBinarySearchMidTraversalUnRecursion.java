// parts of code, not while code.

private Stack<TreeNode> stack = new Stack<>();

public BSTIterator(TreeNode root) {
	while (root != null) {
		stack.push(root);
		root = root.left;
	}
}

public boolean hasNext() {
	return !stack.isEmpty();
}

public TreeNode next() {
	TreeNode curt = stack.peek();
	TreeNode node = curt;

	if (node.right = null) {
		node = stack.pop(); // 如果右子树为空，就pop出来分析一波
		while(!stack.isEmpty() && stack.peek().right == node) {
			node = stack.pop(); // 一直pop，要么是这个栈空了，要么是pop出来一个左子树的关系，然后就停下来
		}
	} else { // 右子树非空，就把右子树中所有左边的点拿到stack中
		node = node.right;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	return curt;
}
