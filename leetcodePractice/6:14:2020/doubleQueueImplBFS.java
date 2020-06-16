public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> results = new ArrayList<List<Integer>>();
	if (root == null) {
		return results;
	}

	List<TreeNode> queue = new ArrayList<>();
	queue.add(root);

	while (!queue.isEmpty()) {
		List<TreeNode> next_queue = new ArrayList<>();
		result.add(toIntegerList(queue));

		for (TreeNode node : queue) {
			if (node.left != null) {
				next_queue.add(node.left);
			}
			if (node.right != null) {
				next_queue.add(node.right);
			}
		}
		queue = next_queue;
	}
	return results;
}

private List<Integer> toIntegerList(List<TreeNode> queue) {
	List<Integer> level = new ArrayList<Integer>();
	for (TreeNode node : queue) {
		level.add(node.val);
	}
	return level;
}
