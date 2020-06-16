def isBalanced(root):
	is_balanced, _ = divideConquer(root)
	return is_balanced

# 定义：判断root为根的二叉树是否是平衡树并且返回高度是多少
def divideConquer(root):
	# 出口：如果是空树🌲， 直接返回是平衡的，高度为0
	if not root:
		return True, 0
	
	# 拆解：拆解到左右子树，得到左右子树是否是平衡和高度的信息
	is_left_balanced, left_height = divideConquer(root.left)
	is_right_balanced, right_height = divideConquer(root.right)
	root_height = max(left_height, right_height) + 1

	if not is_left_balanced or not is_right_balanced:
		return False, root_height
	if abs(left_height - right_height) > 1:
		return False, root_height
	return True, root_height
