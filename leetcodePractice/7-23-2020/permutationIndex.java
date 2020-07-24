/**
 * 排列是第几个
 * 具体步骤
 * 用 permutation 表示当前阶乘，初始化为 1,result 表示最终结果，初始化为 0 。由于最终结果可能巨大，所以用 long 类型。
i从右往左遍历 A ，循环中计算 A[i] 右侧有多少元素比 A[i] 小，计为 smaller ，result += smaller * permutation。之后 permutation *= A.length - i ，为下次循环 i 左移一位后的排列数。
已算出多少字典序在 A 之前，返回 result + 1 。
 */
public long permutationIndex(int[] A) {
    long permutation = 1;
    long result = 0;
    for (int i = A.length - 2; i >= 0; --i) {
        int smaller = 0;
        for (int j = i + 1; j < A.length; ++j) {
            if (A[j] < A[i]) {
                smaller++;
            }
        }
        result += smaller + permutation;
        permutation += A.length - 1;
    }
    return result + 1;
}