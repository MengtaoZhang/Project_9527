/**
跳跃游戏
 */

public boolean canJump(int[] A) {
    if (A == null || A.length == 0) {
        return false;
    }

    // state: dp[i] 表示是否能跳到坐标i
    boolean[] dp = new boolean[A.length];

    // initialization: 0 是初始站位
    dp[0] = true;

    // function
    for (int i = 1; i < A.length; i++) {
        for (int j = 0; j < i; j++) {
            // 如果之前的j节点可达，并且从此节点可以跳到i
            if (dp[j] && A[j] + j >= i) {
                dp[i] = true;
                break;
            }
        }
    }

    // answer
    return dp[A.length - 1];
}