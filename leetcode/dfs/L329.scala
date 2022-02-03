object Solution {
    private var m = -1
    private var n = -2
    private var f: Array[Array[Int]] = null
    private var matrix: Array[Array[Int]] = null
    private val vectors = Array((1, 0), (-1, 0), (0, -1), (0, 1))
    // dfs记忆化搜索
    def longestIncreasingPath(_matrix: Array[Array[Int]]): Int = {
        matrix = _matrix
        m = matrix.length
        n = matrix(0).length
        f = Array.ofDim(m, n)

        var res = -1
        for (i <- 0 until m; j <- 0 until n) {
            res = res.max(dp(i, j))
        }
        res
    }

    private def dp(i: Int, j: Int): Int = {
        def inRange(x: Int, y: Int): Boolean = x >= 0 && x < m && y >= 0 && y < n
        // >0 说明被搜索过
        if (f(i)(j) > 0) return f(i)(j)

        f(i)(j) = 1
        for (v <- vectors) {
            val x = i + v._1; val y = j + v._2
            if (inRange(x, y) && matrix(i)(j) < matrix(x)(y)) f(i)(j) = math.max(f(i)(j), dp(x, y) + 1)
        }
        f(i)(j)
    }
}