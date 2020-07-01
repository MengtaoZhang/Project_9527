/**
siftdown 更有效率的算法，之前的事从儿子找父亲，现在是从父亲找儿子
O（n）的效率

T(n) = O(n/4) + O(n/8 * 2) + O(n/16 * 3) ...
 */

public void siftdown(int[] A, int k) {
    while (k * 2 + 1 < A.length) {
        int son = k * 2 + 1; // A[i] left son index
        if (k * 2 + 2 < A.length && A[son] > A[2 * k + 2]) {
            son = k * 2 + 2;
        }
        if (A[son] >= A[k]) {
            break;
        }

        int temp = A[son];
        A[son] = A[k];
        A[k] = temp;
        k = son;  // 选择较浅深度的父亲节点 k就代表的是父亲节点的索引值
    }
}

public void heapify(int[] A) {
    for (int i = (A.length - 1) / 2; i >= 0; i--) {
        siftdown(A, i);
    }
}