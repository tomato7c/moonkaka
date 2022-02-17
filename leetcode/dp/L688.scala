object Solution {
    private val vectors = Array((-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1))
    // f(i,j,k)表示从(i,j)开始，走k步后仍在棋盘内的概率
    // f(i,j,k) = f(x,y,k - 1) / 8
    def knightProbability(n: Int, _k: Int, row: Int, column: Int): Double = {
        def inRange(x: Int, y: Int): Boolean = x >= 0 && x < n && y >= 0 && y < n
        val dp: Array[Array[Array[Double]]] = Array.ofDim(n, n, _k + 1)
        for (i <- 0 until n; j <- 0 until n) dp(i)(j)(0) = 1.0
        
        for (k <- 1 to _k) {
            for (i <- 0 until n; j <- 0 until n) {
                for ((dx, dy) <- vectors) {
                    val x = i + dx; val y = j + dy
                    if (inRange(x, y)) {
                        dp(i)(j)(k) += dp(x)(y)(k - 1) / 8
                    }
                }
            }
        }
        dp(row)(column)(_k)
    }
}