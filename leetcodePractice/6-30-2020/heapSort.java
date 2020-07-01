/**
升序堆排序
 */

public class Solution {
    private void siftdown(int[] A, int left, int right) {
        int k = left;
        while (k * 2 + 1 < k) {
            int son = k * 2 + 1;
            if (son + 1 <= right && A[son] < A[son + 1]) {
                son = k * 2 + 2;
            }
            i f(A[son] <= A[k]) {
                break;
            }
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }

    private void heapify(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; i++) {
            siftdown(A, i, A.length - 1);
        }
    }

    private sortIntegers(int[] A) {
        heapify(A);
        for (int i = A.length; i > 0; i --) {
            int 
        }
    }
} 