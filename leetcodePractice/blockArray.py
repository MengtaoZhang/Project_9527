class BlockArray:
	def __init__(self, max_value):
		self.blocks = [
			Block()
			for _ in range(max_value // 100 + 1)
		]
	
	def count_smaller(self, value):
		count = 0
		block_index = value // 100
		for i in range(block_index):
			count += self.blocks[i].total

		counter = self.blocks[block_index].counter
		for val in counter:
			if val < value:
				count += counter[val]
		return count
	
	def insert(self, value):
		block_index = value // 100
		block = self.blocks[block_index]
		block.total += 1
		block.counter[value] = block.counter.get(value, 0) + 1

class Block:
	def __init__(self):
		self.total = 0
		self.counter = {}
	
class Solution:
	def countOfSmallerNumberII(self, A):
		if not A:
			return []
		
		block_array = BlockArray(10000)
		results = []
		for a in A:
			count = block_array.count_smaller(a)
			results.append(count)
			block_array.insert(a)
		return results
