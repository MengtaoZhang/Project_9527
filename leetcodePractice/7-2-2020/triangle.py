'''
针对数字三角形的问题，使用动态规划来完成
自底向上的动态规划
'''

def minimumTotal(self, triangle):
    n =  len(triangle)

    # state: dp[i][j] 代表i, j 走到最底层的最短路径值
    # dp数组-》状态函数，i，j用于表示子问题，子问题就是从i，j出发到达底部的路经长度
    # 这个题用两个参数就可以描述子问题了，由多少个参数描述子问题取决于自问题自身需求
    dp = [[0] * (i + 1) for i in range(n)]

    # initialize： 初始化终点（最后一层）
    for i in range(n):
        dp[n - 1][i] = triangle[n - 1][i]

    # function :从下往上倒过来推倒， 计算每个坐标到哪儿去
    for i in range(n - 2, -1, -1):
        for j in range(i + 1):
            dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]

    # answer : 起点就是答案
    return dp[0][0]
    

'''
有自底向上的动态规划
自然就有自顶向下的动态规划
'''

def minimumTotalII(self, triangle):
    n = len(triangle)

    # state: sp[i][j] 代表从0，0走到i，j的最短路径值
    dp = [[0] * (i + 1) for i in range(n)]


    #initialize：三角形的左边和右边要初始化
    # 因为它们分别没有左上角的点和右上角的点
    dp[0][0] = triangle[0][0]
    for i in range(1, n):
        dp[i][0] = dp[i - 1][0] + triangle[i][0]
        dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]

    # function：dp[i][j] - min(dp[i - 1][j - 1], dp[i - 1][j] + triangle[i][j])
    # i, j 这个位置是从位置 i - 1, j 或者 i - 1， j - 1 走过来的
    for i in range(2, n):
        for j in range(1, i):
            dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]

    # answer： 最后一层的任意位置都可以是路经的终点
    return min(dp[n - 1])