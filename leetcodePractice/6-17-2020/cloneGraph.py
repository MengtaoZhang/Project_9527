def cloneGraph(self, node):
	root = node
	if node is None:
		return node

	# use bfs algorithm to traverse the graph and get all nodes.
	nodes = self.getNodes(node)

	# copy nodes, store the old -> new mapping information in a hash map
	mapping = {}
	for node in nodes:
		mapping[node] = UndirectedGraphNode(node.label)
	
	# copy neighbors(edges)
	for node in nodes:
		new_node = mapping[node]
		for neighbor in node.neighbors:
			new_neighbor = mapping[neighbor]
			new_node.neighbors.append(new_neighbor)

	return mapping[root]
