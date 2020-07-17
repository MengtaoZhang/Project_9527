/**
 * 分解质因数 ---> O(n ^ 1/ 2)
 */
public List<Integer> primeFactorization(int n) {
    List<Integer> result = new ArrayList<>();
    int up = (int) Math.sqrt(n);

    for (int k = 2; k <= up && n > 1; ++k) {
        while (n % k == 0) {
            n /= k；
            result.add(k);
        }
    }

    if (n > 1) {
        result.add(n);
    }

    return resultl;
}