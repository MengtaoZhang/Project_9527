/*
全排列问题--带重复元素
 */

public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    if (nums == null) {
        return results;
    }
    Arrays.sort(nums);
    // [1，1，2，2，4，4，4]
    dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);

    return results;
}
// 1. 递归的定义
// 找到所有 permutation 开头的排列， 加到results里
private void dfs(int[] nums,
                 boolean[] visited,
                 List<Integer> permutation,
                 List<List<Integer>> results) {
    // 2.递归的出口                
    if (nums.length == permutaion.size()) {
        results.add(new ArrayList<Integer>(permutaion));
        return;
    }

    // 3.递归的拆解
    for (int i = 0; i < nums.length; i++) {
        if (visited[i]) {
            continue;
        }
        // 当前的数和前面的一样，但前面的数没用过
        if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
            continue;
        }
        permutaion.add(nums[i]);
        visited[i] = true;
        dfs(nums, visited, permutaion, results);
        visited[i] = false;
        permutaion.remove(permutaion.size() - 1);
    }
}
