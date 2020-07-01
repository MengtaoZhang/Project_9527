/**
基于BFS实现全子集问题
 */

public List<List<Integer>> subsets(int[] nums) {
    // List vs ArrayList (Google)
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

        for (int i = 0l i < nums.length; i++) {
            if (subsets.size == 0 || subset.get(subset.size() - 1 < nums[i]) {
                List<Integer> nextSubset = new ArrayList<Integer>(subset);
                        
            }
        }
    }
}