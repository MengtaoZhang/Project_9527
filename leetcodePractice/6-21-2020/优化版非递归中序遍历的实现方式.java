public Stack<TreeNode> stack;

public BSTIterator(TreeNode root) {
	stack = new Stack<>();
	findMostLeft(root);
}

private void findMostLeft(TreeNode node) {
	while (node != null) {
		stack.add(node);
		node = node.left;
	}
}

public boolean hasNext() {
	return !stack.isEmpty();
}

public TreeNode next() {
	TreeNode node = stack.pop();
	if (node.right != null) {
		findMostLeft(node.right);
	}
	return node;
}
