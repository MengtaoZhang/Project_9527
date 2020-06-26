/*
全排列，lintcode-15
 */

public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    if (nums == null) {
        return permutations;
    }
    if (nums.length == 0) {
        permutations.add(new ArrayList<Integer>());
        return permutations;
    }

    boolean[] visited = new boolean[nums.length];
    List<Integer> permutations = new ArrayList<>();
    dfs(nums, visited, permutation, permutations);

    return permutations;
}

// 递归的定义：找到以permutation开头的所有排列
private void dfs(int[] nums,
                 boolean[] visited,
                 List<Integer> permutation,
                 List<List<Integer>> permutations){
    // 递归的出口：当当前排列的长度等于集合长度
    if (permutation.size() == nums.length) {
        permutations.add(new ArrayList<Integer>(permutation));
        return;
    }

    // 递归的拆解
    // [] -> [1], [2], [3] ...
    // [1] -> [1,2], [1,3], [1,4] ...
    for (int i = 0; i < nums.length; i++) {
        if (visited[i]) {
            continue;
        }
        visited[i] = true;
        permutation.add(nums[i]);
        dfs(nums, visited, permutation, permutations);
        permutation.remove(permutation.size() - 1); //backtracking
        visited[i] = false; // backtracking
    }
}