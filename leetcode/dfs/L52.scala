object L52 {

    private var res: Int = -1
    private var col: Array[Boolean] = null
    private var n: Int = -1
    private var diag: collection.mutable.Set[Int] = null
    private var ndiag: collection.mutable.Set[Int] = null

    // 枚举每行中哪列放皇后；皇后位置映射到对角线，可以通过截距映射
    def totalNQueens(_n: Int): Int = {
        n = _n
        res = 0
        col = Array.ofDim(n)
        diag = collection.mutable.Set[Int]()
        ndiag = collection.mutable.Set[Int]()
        val board: Array[Array[Char]] = Array.ofDim(n, n)
        // init
        for (i <- 0 until n; j <- 0 until n) board(i)(j) = '.'

        dfs(board, 0)
        res
    }

    private def dfs(board: Array[Array[Char]], row: Int) {
        if (row == n) {
            res += 1
            return
        }

        for (index <- 0 until n) {
            if (!col(index) && !diag.contains(row - index) && !ndiag.contains(row + index)) {
                // store
                col(index) = true
                diag += row - index
                ndiag += row + index
                board(row)(index) = 'Q'
                dfs(board, row + 1)
                // restore
                col(index) = false
                diag -= row - index
                ndiag -= row + index
                board(row)(index) = '.'
            }
        }
    }
}