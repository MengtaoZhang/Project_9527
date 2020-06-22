class BSTIterator:
	def __init__(self, root):
		self.stack = []
		self.find_most_left(root)
	
	def find_most_left(root):
		while node:
			self.stack.append(node)
			node = node.left

	def hasNext(self):
		return bool(self.stack)

	def next(self):
		node = self.stack.pop()
		if node.right:
			self.find_most_left(node.right)
		return node

