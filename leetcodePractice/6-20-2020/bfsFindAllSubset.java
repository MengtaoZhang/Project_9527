public List<List<Integer>> subsets(int[] nums) {
	if (nums == null) {
		return new ArrayList<>();
	}

	List<List<Integer>> queue = new ArrayList<>();
	int index = 0;

	Array.sort(nums);
	queue.add(new ArrayList<Integer>());
	while (index < queue.size()) {
		List<Integer> subset = queue.get(index++); 
		// poll一个元素出来，然后for他所有的邻居，for邻居的方式是在当前的subset后面增加一个元素
		// 增加的话要考虑去重的因素，2后面不能有1，只能比2大，就在if里面需要比一下最后一个元素与当前元素的大小谁大
		for (int i = 0; i < nums.length; i++) {
			if (subset.size() != 0 && subset.get(subset.size() - 1) >= nums[i]){
				continue;
			} // 不要重复元素
			List<Integer> newSubset = new ArrayList<>(subset);
			newSubset.add(nums[i]);
			queue.add(newSubset);
		}
	}
	return queue;
}

