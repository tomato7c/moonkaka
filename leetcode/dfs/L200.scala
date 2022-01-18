object L200 {

    private val vectors = Array[(Int, Int)]((1, 0), (-1, 0), (0, -1), (0, 1))

    // dfs or bfs
    def numIslands(grid: Array[Array[Char]]): Int = {
        var res = 0
        for (i <- 0 until grid.length; j <- 0 until grid(0).length if grid(i)(j) == '1') {
            dfs(grid, i, j)
            res += 1
        }
        res
    }

    private def dfs(grid: Array[Array[Char]], x: Int, y: Int) {
        if (!inGrid(grid, x, y)) return
        if (grid(x)(y) != '1') return
        
        grid(x)(y) = '0'
        for (v <- vectors) {
            dfs(grid, x + v._1, y + v._2)
        }
    }

    private def inGrid(grid: Array[Array[Char]], x: Int, y: Int): Boolean = {
        x >= 0 && x < grid.length && y >= 0 && y < grid(0).length
    }
}