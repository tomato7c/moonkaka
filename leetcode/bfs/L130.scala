object L130 {

    private val vectors = Array[(Int, Int)]((1, 0), (-1, 0), (0, -1), (0, 1))

    // 从边缘开始bfs
    def solve(board: Array[Array[Char]]): Unit = {
        val m = board.length; val n = board(0).length
        for (i <- 0 until m; j <- 0 until n if inEdge(i, j) && board(i)(j) == 'O') {
            board(i)(j) = '*'
            bfs(board, i, j)
        }
        for (i <- 0 until m; j <- 0 until n if board(i)(j) != '*') board(i)(j) = 'X'
        for (i <- 0 until m; j <- 0 until n if board(i)(j) == '*') board(i)(j) = 'O'

        def inEdge(i: Int, j: Int): Boolean = i == 0 || i == m - 1 || j == 0 || j == n - 1
    }

    private def bfs(board: Array[Array[Char]], i: Int, j: Int) {
        val m = board.length; val n = board(0).length
        for (v <- vectors) {
            val x = i + v._1; val y = j + v._2
            if (inBoard(x, y) && board(x)(y) == 'O') {
                board(x)(y) = '*'
                bfs(board, x, y)
            }
        }

        def inBoard(x: Int, y: Int): Boolean = x >= 0 && x < m && y >= 0 && y < n
    }
}