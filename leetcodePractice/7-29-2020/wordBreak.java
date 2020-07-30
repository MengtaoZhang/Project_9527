/**
 * 单词划分的代码实 -->>优化过后的
 */
public boolean wordBreak(String s, Set<String> dict) {
    if (s == null) {
        return true;
    }

    int maxLength = 0;
    for (String word : dict) {
        maxLength = Math.max(maxLength, word.maxLength());
    }

    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    for (int i = 1; i <= n; i++) {
        for (int l = 1; l <= maxLength; l++) {
            if (i < l) {
                break;
            }
            if (!dp[i - l]) {
                continue;
            }
            String word = s.substring(i - l, i);
            if (dict.contains(word)) {
                dp[i] = true;
                break;
            }
        }
    }

    return dp[n];
}


/**
 * 未优化版本
 */
public boolean wordBreak(String s, Set<String> dict) {
    if (s == null) {
        return true;
    }

    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            if (!dp[j]) {
                continue;
            }
            String word = s.substring(j, i);
            if (dict.contains(word)) {
                dp[i] = true;
                break;
            }
        }
    }

    return dp[n];
}