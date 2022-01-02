object L64 {
    // f(i)(j) 维护到达当前位置的最小sum f(i)(j) = min f(i - 1)(j), f(i)(j - 1)
    def minPathSum(grid: Array[Array[Int]]): Int = {
        val m = grid.length
        val n = grid(0).length
        val dp: Array[Array[Int]] = Array.ofDim(m, n)
        dp(0)(0) = grid(0)(0)
        // init
        for (i <- 1 until m) dp(i)(0) = dp(i - 1)(0) + grid(i)(0)
        for (j <- 1 until n) dp(0)(j) = dp(0)(j - 1) + grid(0)(j)

        for (i <- 1 until m; j <- 1 until n) dp(i)(j) = Math.min(dp(i - 1)(j), dp(i)(j - 1)) + grid(i)(j)

        dp(m - 1)(n - 1)
    }
}