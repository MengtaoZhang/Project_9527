public List<String> binaryTreePaths(TreeNode root) {
	List<String> paths = new ArrayList<>();

	if (root == null) {
		return paths;
	}
	if (root.left == null && root.right == null) {
		path.add("" + root.val);
		return paths;
	}

	for (String leftPath : binaryTreePaths(root.left)) {
		paths.add(root.val + "->" + leftPath);
	}
	for (String rightPath : binaryTreePaths(root.right)) {
		paths.add(root.val +"->" + rightPath);
	}
	
	return paths;
}

//　これわ分治法です
