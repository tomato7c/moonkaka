object L221 {
    // dp，主要是想清右下与其他三个值的关系
    // dp(i)(j)表示以(i,j)为右下端点的正方形面积
    def maximalSquare(matrix: Array[Array[Char]]): Int = {
        val m = matrix.length; val n = matrix(0).length
        val dp: Array[Array[Int]] = Array.ofDim(m, n)
        var max = 0
        for (i <- 0 until m; j <- 0 until n if matrix(i)(j) != '0') {
            val minLength = safeIndex(dp, i - 1, j).min(safeIndex(dp, i, j - 1)).min(safeIndex(dp, i - 1, j - 1))
            dp(i)(j) = minLength + 1
            max = math.max(max, dp(i)(j))
        }
        max * max
    }

    private def safeIndex(arr: Array[Array[Int]], x: Int, y: Int): Int = {
        val m = arr.length; val n = arr(0).length
        if (x >= 0 && x < m && y >= 0 && y < n) arr(x)(y) else 0
    }
}