/**
 *  全排列问题-》基于下一个排列的答案，只需要不断调用这个算法的函数即可
 * 
 */
public List<List<Integer>> permute(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    
    boolean next = true;  // next 为 true 时，表示可以继续迭代
    while (next)  {
        List<Integer> current = new ArrayList<>();  // 进行数组复制
        for (int num : nums) {
            current.add(num);
        }
        
        result.add(current);
        next = nextPermutation(nums);
    }
    return result;
}

public void swapItem(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

// 用于翻转nums[i] 到 nums[j], 包含两端的这一小段数组
public void swapList(int[] nums, int i, int j) {
    while (i < j) {
        swapItem(nums, i, j);
        i++;
        j--;
    }
}

public boolean nextPermutation(int[] nums) {
    int len = nums.length;
    int i = len - 1;
    while (i > 0 && nums[i] <= nums[i - 1]) {
        i--;
    }
    if (i <= 0) {
        return false;
    }
    
    int j = len - 1;
    while (nums[j] <= nums[i - 1]) {
        j--;
    }
    swapItem(nums, j, i - 1);
    
    swapList(nums, i, len - 1);
    
    return true;
}