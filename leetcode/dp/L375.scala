object Solution {
    // f(i,j)表示[i,j]内最小代价 则f(i,j) = min(max(f(i, x - 1), f(x + 1, j)) + x)
    def getMoneyAmount(n: Int): Int = {
        val dp: Array[Array[Int]] = Array.ofDim(n + 2, n + 2)
        // dp(0)(x),dp(x)(0) 为0，无候选者
        for (window <- 2 to n) {// window为1时dp(i)(j)为0
            for (l <- 1 to n - window + 1) {
                val r = l + window - 1
                dp(l)(r) = Int.MaxValue
                for (x <- l to r) {
                    val candidate = math.max(dp(l)(x - 1), dp(x + 1)(r)) + x
                    dp(l)(r) = dp(l)(r) min candidate
                } 
            }
        }
        dp(1)(n)
    }
}