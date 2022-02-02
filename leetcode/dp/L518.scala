object Solution {
    // 类比322, 注意边界条件
    def change(amount: Int, coins: Array[Int]): Int = {
        val m = coins.length; val n = amount
        val dp: Array[Array[Int]] = Array.ofDim(m + 1, n + 1)
        for (i <- 0 to m) dp(i)(0) = 1

        for (i <- 1 to m) {
            val v = coins(i - 1)
            for (j <- 1 to n) {
                dp(i)(j) = dp(i - 1)(j)
                for (k <- 1 to j / v) dp(i)(j) += dp(i - 1)(j - v * k)
            }
        }
        dp(m)(n)
    }
}