object Solution {

    private val vectors = Array((1, 0), (-1, 0), (0, 1), (0, -1), (-1, -1), (1, -1), (1, 1), (-1, 1))

    def gameOfLife(board: Array[Array[Int]]): Unit = {
        val m = board.length; val n = board(0).length
        val arr: Array[Array[Int]] = Array.ofDim(m, n)
        for (i <- 0 until m; j <- 0 until n) {
            val live = countLiveAndDied(board, i, j)
            if (board(i)(j) == 1) { // 活细胞
                if (live < 2) {
                    arr(i)(j) = 0
                } else if (live <= 3) {
                    arr(i)(j) = 1
                } else {
                    arr(i)(j) = 0
                }
            } else {
                if (live == 3) {
                    arr(i)(j) = 1
                }
            }
        }

        for (i <- 0 until m; j <- 0 until n) board(i)(j) = arr(i)(j)

    }

    private def countLiveAndDied(board: Array[Array[Int]], a: Int, b: Int): Int = {
        val m = board.length; val n = board(0).length
        var live = 0
        for (v <- vectors) {
            val x = a + v._1; val y = b + v._2
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (board(x)(y) == 1) live += 1
            }
        }
        live
    }
}