/**
 * 解码方式问题及代码实现
 * 直接优化为滚动数组
 */
public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }

    int n = s.length();

   // state: dp[i % 3] = 前 i 个字符有多少种解码方式
   int[] dp = new int[3];

    // initialization
    dp[0] = 1;
    dp[1] = decodeOK(s.substring(0, 1));

    for (int i = 2; i <= n; i++) {
        dp[i % 3] = dp[(i - 1) % 3] * decodeOK(s.substring(i - 1, i)) + 
                    dp[(i - 2) % 3] * decodeOK(s.substring(i - 2, i));
    }

    return dp[n % 3];
}

private int decodeOK(String substr) {
    int code = Integer.parseInt(substr);
    int len = substr.length();
    if (len == 1 && code >= 1 && code <= 9) {
        return 1;
    }
    if (len == 2 && code >= 10 && code <= 26) {
        return 1;
    }
    return 0;
}