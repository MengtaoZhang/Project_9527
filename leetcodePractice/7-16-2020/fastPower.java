/**
 * 递归方法的快速幂算法
 */
public int fastPower(int a, int b, int n) {
    if (n == 1) {
        return a % b;
    }
    if (n == 0) {
        return 1 % b;
    }

    long product = fastPower(a, b, n / 2);
    product = (product * product) % b;
    if (n % 2 == 1) {
        product = (product * a) % b;
    }
    return (int) product;
}

/**
 * 使用二进制转换的方法实现快速幂----非递归
 */
public int fastPower(int a, int b, int n) {
    long ans = 1, tmp = a;
    while (n != 0) {
        if (n % 2 == 1) {
            ans = (ans * tmp) % b;
        }
        tmp = (tmp * tmp) % b;
        n = n / 2;
    }
    return (int) ans % b;
}