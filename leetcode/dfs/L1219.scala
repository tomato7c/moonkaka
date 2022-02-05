object Solution {

    private var visited: Array[Array[Boolean]] = null
    private val vectors = Array((1, 0), (-1, 0), (0, 1), (0, -1))

    def getMaximumGold(grid: Array[Array[Int]]): Int = {
        val m = grid.length; val n = grid(0).length
        visited = Array.ofDim(m, n)
        var res = -1
        for (i <- 0 until m; j <- 0 until n) res = res.max(dfs(grid, i, j))
        res
    }

    private def dfs(grid: Array[Array[Int]], i: Int, j: Int): Int = {
        if (!canCollect(grid, i, j)) return 0
        var res = grid(i)(j)
        visited(i)(j) = true
        for (v <- vectors) {
            val x = i + v._1; val y = j + v._2
            res = res.max(grid(i)(j) + dfs(grid, x, y))
        }
        visited(i)(j) = false
        res
    }

    private def canCollect(grid: Array[Array[Int]], x: Int, y: Int): Boolean = {
        val m = grid.length; val n = grid(0).length
        if (x < 0 || x >= m || y < 0 || y >= n) return false
        if (visited(x)(y)) return false
        if (grid(x)(y) == 0) return false
        true
    }
}