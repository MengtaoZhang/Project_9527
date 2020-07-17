/**
 * median of two sorted array
 * 算法描述：
 * 1. 先将找终点问题转化为找第 k 小的问题，这里直接令 k = (n + m) / 2。 那么目标是在
 *    logk = log((n + m) / 2) = log(n + m)的时间内找到A和B数组中从小到大第k个
 * 2. 比较A数组的第 k / 2 小和 B数组的第 k / 2 小的数，谁的小，就扔掉谁的前 k / 2 个数
 * 3. 将目标寻找第 k 小修改为寻找第 （k - k / 2）小
 * 4. 回到第 2 步继续做，直到 k == 1 或者 A 数组 B数组里已经没有数了。
 * 
 * 该题还有基于二分的算法
 * 描述：
 * 1. 我们需要先确定二分的上下界限，由于两个数组 A, B 均有序，
 * 所以下界为 min(A[0], B[0])，上界为 max(A[A.length - 1], B[B.length - 1]).
 * 
 * 2. 判断当前上下界限下的 mid(mid = (start + end) / 2) 是否为我们需要的答案；
 * 这里我们可以分别对两个数组进行二分来找到两个数组中小于等于当前 mid 的数的个数cnt1与 cnt2，
 * sum = cnt1 + cnt2 即为 A 跟 B 合并后小于等于当前mid的数的个数.
 * 
 * 3. 如果 sum < k，即中位数肯定不是 mid，应该大于 mid，更新 start 为 mid，
 * 否则更新 end 为 mid，之后再重复第二步
 * 
 * 4. 当不满足 start + 1 < end 这个条件退出二分循环时，再分别判断一下start跟 end ，
 * 最终返回符合要求的那个数即可
 * 
 * 详细解释：
 * 这一题如果用二分法来做，其实就是一个二分答案的过程
首先我们已经得到了上下界限，那么答案必定是在这个上下界限中的，需要实现的就是从这个上下界限中找出答案
我们每次取的 mid，其实就是我们每次在假设答案为 mid，二分的过程就是不断的推翻这个假设，然后再假设新的答案
需要满足的条件为：
上面算法描述中的 sum 需要等于 k，这里的 k = (A.length + B.length) / 2. 如果 sum < k，很明显当前的 mid 偏小，需要增大，否则就说明当前的 mid 偏大，需要缩小.
最终在 start 与 end 相邻的时候退出循环，判断 start 跟 end 哪个符合条件即可得到最终结果
 */
public double findMedianSortArrays(int A[], int B[]) {
    int len = A.length + B.length;
    if (len % 2 == 1) {
        return findKth(A, 0, B, 0, len / 2 + 1);
    }
    return (
        findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
    ) / 2.0;
    }
}

// find kth number of two sorted array
public static int findKth(int[] A, int A_start,
                          int[] B. int B_start,
                          int k) {
    if (A_start >= A.length) {
        return B[B_start + k - 1];
    }
    if (B_start >= B.length) {
        return A[A_start + k - 1];
    }

    if (k == 1) {
        return Math.min(A[A_start], B[B_start]);
    }

    int A_key = A_start + k / 2 - 1 < A.length 
                ? A[A_start + k / 2 - 1]
                : Integer.MAX_VALUE;
    int B_key = B_start + k / 2 - 1 < B.length
                ? B[B_start + k / 2 - 1]
                : Integer.MAX_VALUE;

    if (A_key < B_key) {
        return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
    } else {
        return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
    }

}