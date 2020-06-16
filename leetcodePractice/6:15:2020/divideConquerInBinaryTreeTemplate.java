public 返回结果类型 divideConquer(TreeNode root) {
	if (root == null) {
		处理空树应该返回的结果；
	}

	// if (root.left == null && root.right == null) {
	//		处理叶子应该返回的结果
	//		如果叶子的返回结果可以通过两个空节点的返回结果得到
	//		就可以省略这一段代码
	//	}

	左子树返回结果= divideConquer(root.left);
	右子树返回结果= divideConquer(root.right);
	整棵树的结果= 按照一定的方法合并左右子树的结果

	return 整棵树的结果
}

