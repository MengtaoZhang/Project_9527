// Finding nodes doesn't need backtracking by hand. OS will control all.


public void findNodes(TreeNode node, List<TreeNode> nodes) {
	if (node == null) {
		return;
	}

	nodes.add(node);
	findNodes(node.left, nodes);
	findNodes(node.right, nodes);
}


