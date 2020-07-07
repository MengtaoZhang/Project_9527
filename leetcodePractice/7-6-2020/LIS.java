/**
longest increasing subsequence
 */

public int longestIncreasingSubsequence(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    int n = nums.length;

    // state:
    // dp[i] 表示从左到右跳到i的最长sequence的长度
    // prev[i] 代表 dp[i] 的最优值是从哪个 dp[i] 算过来的
    int[] prev = new int[n];
    int[] dp = new int[n];

    // initialization: dp[0...n - 1] = 1
    for (int i = 0; i < n; i++) {
        dp[i] = 1;
        prev[i] = -1;
    }  

    // function dp[i] = max{dp[j] + 1}, j < i and nums[j] < nums[i]
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i] && dp[j] + 1 > dp[i] {
                dp[i] = dp[i] + 1;
                prev[i] = j;
            }
        }
    }

    // answer: max(dp[0...n - 1])
    int longest = 0, last = -1;
    for (int i = 0; i < n; i++) {
        if(dp[i] > longest) {
            longest = dp[i];
            last = i;
        }
    }

    // print solution
    ArrayList<Integer> path = new ArrayList<>();
    while (lats != -1) {
        path.add(nums[last]);
        last = prev[last];
    }
    for (int i = path.size() - 1; i >= 0; i--) {
        System.out.print(path.get(i) + "-");
    }

    return longest;
}