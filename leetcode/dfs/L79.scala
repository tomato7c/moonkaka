object L79 {
    private val vector = Array[(Int, Int)]((1, 0), (-1, 0), (0, -1), (0, 1))

    // 向四个方向dfs
    def exist(board: Array[Array[Char]], word: String): Boolean = {
        val m = board.length; val n = board(0).length
        for (i <- 0 until m; j <- 0 until n) {
            if (dfs(board, word, 0, i, j)) return true
        }
        false
    }

    private def dfs(board: Array[Array[Char]], word: String, index: Int, i: Int, j: Int): Boolean = {
        if (board(i)(j) != word(index)) return false
        if (index == word.length - 1) return true
        val temp = board(i)(j)
        board(i)(j) = '*'
        for (t <- vector) {
            val x = i + t._1; val y = j + t._2
            if (x >= 0 && x < board.length 
            && y >= 0 && y < board(0).length 
            && dfs(board, word, index + 1, x, y)) {
                return true
            }
        }

        board(i)(j) = temp
        false
    }
}