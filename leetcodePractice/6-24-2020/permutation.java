/*
全排列问题
 */

public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    if (nums == null) {
        return results;
    }

    dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);

    return results;
}

private void dfs(int[] nums,
                 boolean[] visited,
                 List<Integer> permutation,
                 List<List<Integer>> results) {
    if (nums.length == permutaion.size()) {
        results.add(new ArrayList<Integer>(permutaion));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (visited[i]) {
            continue;
        }

        permutaion.add(nums[i]);
        visited[i] = true;
        dfs(nums, visited, permutaion, results);
        visited[i] = false;
        permutaion.remove(permutaion.size() - 1);
    }
}
