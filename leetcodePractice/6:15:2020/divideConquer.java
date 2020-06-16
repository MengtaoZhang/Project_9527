public class Result {
	public boolean isBalanced;
	public int height;
	public Result(boolean isBalanced, int height) {
		this.isBalanced = isBalanced;
		this.height = height;
	}
}

// 定义：求出root为根节点的子树是否是平衡树且返回高度
private Result divideConquer(TreeNode root) {
	// 出口：空树的时候，返回 isbalanced=true, height=0
	if (root == null) {
		return new Result(true, 0);
	}

	// 拆解：拆解到左右两边得到左右子树的平衡信息和高度信息
	Result leftResult = divideConquer(root.left);
	Result rightResult = divideConquer(root.right);

	int height = Max.max(leftResult.height, rightResult.height) + 1;
	boolean isBalanced = true;

	if (!leftResult.isBalanced || !rightResult.isBalanced) {
		isBalanced = false;
	}
	if (Math.abs(leftResult.height - rightResult.height) > 1) {
		isBalanced = false;
	}

	return new Result(isBalanced, height);
}
