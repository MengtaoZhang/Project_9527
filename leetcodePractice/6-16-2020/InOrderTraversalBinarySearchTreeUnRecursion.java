// 另外一种非递归中序遍历DFS实现方法，经过了一点小优化：栈里存的不是全部节点
// 只存还没被next访问的节点，如果iterator到了这个点，即便右子树未完全遍历，也从stack中pop出
// 还有一个是包装找最左边节点的代码-findMostLeft()

public Stack<TreeNode> stack;

public BSTIterator(TreeNode root) {
	stack = new Stack<>();
	findModesLeft(root);
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
