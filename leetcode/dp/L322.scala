object Solution {

    val INVALID = Int.MaxValue

    // f(i,j)表示使用前i种硬币，兑换成价值j所需要的最少硬币个数
    def coinChange(coins: Array[Int], amount: Int): Int = {
        val m = coins.length; val n = amount
        val dp: Array[Array[Int]] = Array.ofDim(m + 1, n + 1)

        // dp(x)(0) = 0; dp(0)(x) = invalid
        for (j <- 1 to n) dp(0)(j) = INVALID

        for (i <- 1 to m) {
            val v = coins(i - 1)
            for (j <- 1 to n) {
                // 不考虑硬币i
                dp(i)(j) = dp(i - 1)(j)
                // 考虑硬币i
                for (k <- 1 to j / v) {
                    val candidate = dp(i - 1)(j - k * v)
                    if (candidate != INVALID) {
                        dp(i)(j) = dp(i)(j).min(candidate + k)
                    }
                }
            }
        }
        if (dp(m)(n) != INVALID) dp(m)(n) else -1
    }
}