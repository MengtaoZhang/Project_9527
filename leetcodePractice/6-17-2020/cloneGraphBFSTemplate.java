Queue<Node> queue = new LinkedList<>();
HashMap<Node, Integer> distance = new HashMap<>();

// step 1: 初始化
// 把初始节点放到queue里，如果有多个就都放进去
// 并标记初始节点的距离为0， 记录在distance的hashmap里
// distance 有两个作用，一是判断是否已经访问过，二是记录离起点的距离
queue.offer(node);
distance.put(node, 0);

// step 2: 不断访问队列
// while 循环 + 每次pop 队列中的一个点出来
while (!queue.isEmpty) {
	Node node = queue.pool();
	// step 3:拓展相邻节点
	// pop出的节点的相邻节点，加入队列并在distance中存储距离
	for (Node neighbor : node.get_neighbors()) {
		if (distance.containsKey(neighbor)) {
			continue;
		}
		distance.put(neighbor, distance.get(node) + 1);
		queue.offer(neighbor);
	}
}
