object Solution {
    // f(i)表示最少需要多少个数来表示i
    // f(i) = min(f(i - j*j)), j in [0, sqrt(i)]
    def numSquares(n: Int): Int = {
        val dp = new Array[Int](n + 1)
        dp(0) = 0

        for (i <- 1 to n) {
            var min = Int.MaxValue
            for (j <- 1 to math.sqrt(i).toInt) {
                min = math.min(min, dp(i - j * j))
            }
            dp(i) = min + 1
        }
        dp(n)
    }
}