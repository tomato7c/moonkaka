object L63 {
    def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
        if (obstacleGrid(0)(0) == 1) return 0
        val m = obstacleGrid.length
        val n = obstacleGrid(0).length
        val matrix: Array[Array[Int]] = Array.ofDim(m, n)
        matrix(0)(0) = 1
        for (i <- 1 until m) matrix(i)(0) = if (obstacleGrid(i)(0) == 0) matrix(i - 1)(0) else 0
        for (j <- 1 until n) matrix(0)(j) = if (obstacleGrid(0)(j) == 0) matrix(0)(j - 1) else 0
        for (i <- 1 until m; j <- 1 until n) {
            if (obstacleGrid(i)(j) == 1) {
                matrix(i)(j) = 0
            } else {
                matrix(i)(j) = matrix(i - 1)(j) + matrix(i)(j - 1)
            }
        }
        matrix(m - 1)(n - 1)
    }
}