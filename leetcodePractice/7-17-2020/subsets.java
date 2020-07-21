/**
 * 第一种搜索树的BFS实现
 */
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
        for (int i = 0; i < nums.length; i++) {
            if (subset.size() != 0 && subset.get(subset.size() - 1) >= nums[i]) {
                continue;
            }
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(nums[i]);
            queue.add(newSubset);
        }
    }
    return queue
}

/**
 * 第二种搜索树的BFS实现
 * 该方法十分特殊，只适用于这个题目
 */
public List<List<Integer>> subsets(int[] nums) {
    if (nums == null) {
        return new ArrayList<>();
    }   

    List<List<Integer>> queue = new ArrayList<>();
    queue.add(new LinkedList<Integer>());
    Arrays.sort(nums);

    for (int num : nums) {  // 固定层级的一个写法
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            List<Integer> subset = new ArrayList<>(queue.get(i));
            subset.add(num);
            queue.add(subset);
        }
    }
    return queue;
}