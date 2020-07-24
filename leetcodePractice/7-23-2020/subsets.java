/**
 * 进制转换解决全子集问题
 */
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < (1 << n); i++) {
        List<Integer> subset =  new ArrayList<Integer>();
        for (int j = 0; j < n; j++) {
            if ((i & (1 << j)) != 0) {
                subset.add(nums[j]);
            }
        }
        result.add(subset);
    }

    return result;
}

/**
 * 基于BFS的方法
 */
public List<List<Integer>> subsets(int[] nums) {
    // List vs ArrayList -> Google
    List<List<Integer>> results = new LinkedList<>();

    if (nums == null) {
        return results; // 空列表
    }

    Arrays.sort(nums);

    // BFS
    Queue<List<Integer>> queue = new LinkedList<>();
    queue.offer(new ArrayList<Integer>());

    while (!queue.isEmpty()) {
        List<Integer> subset = queue.poll();
        results.add(subset);

        for (int i = 0; i < nums.length; i++) {
            if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]) {
                List<Integer> nextSubset = new ArrayList<Integer>(subset);
                nextSubset.add(nums[i]);
                queue.offer(nextSubset);
            }
        }
    }

    return results;
}