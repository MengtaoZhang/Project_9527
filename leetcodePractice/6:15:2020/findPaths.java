// Finding paths need right backtracking by hand. Higher efficiency.
// 遍历法

public void findPaths(TreeNode node, String path, List<String> paths){
	if (node == null) {
		return;
	}

	if (node.left == null && node.right == null) {
		path.add(path);
		return;
	}

	if (node.left != null) {
		findPaths(node.left, path + "->" + node.left.val, path);
	}
	if (node.right != null) {
		findPaths(node.left, path + "->" + node.left.val, path);
	}
}
