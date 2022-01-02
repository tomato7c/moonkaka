object L62 {
    // f(i)(j) = f(i + 1)(j) + f(i)(j - 1)
    def uniquePaths(m: Int, n: Int): Int = {
        val matrix: Array[Array[Int]] = Array.ofDim(m, n)
        // init
        for (i <- 0 until m) matrix(i)(0) = 1
        for (j <- 0 until n) matrix(m - 1)(j) = 1
        for (i <- (0 until m - 1).reverse; j <- 1 until n) matrix(i)(j) = matrix(i + 1)(j) + matrix(i)(j - 1)

        matrix(0)(n - 1)
    }
}