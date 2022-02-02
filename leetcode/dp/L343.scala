object Solution {
    // f(i)表示i拆分成m个正整数乘积最大值, 假设第一次循环拆成单独的k, 则f(i) = max(k * (i - k), k * f(i - k))
    // 由于0，1不能拆分，f(0) = f(1) = 0
    def integerBreak(n: Int): Int = {
        val dp = new Array[Int](n + 1)
        dp(0) = 0; dp(1) = 0
        for (i <- 2 to n) {
            for (k <- 1 until i) {
                dp(i) = dp(i).max(k * (i - k)).max(k * dp(i - k))
            }
        }
        dp(n)
    }
}