object L37 {
    var row: Array[Array[Boolean]] = null // 每一行1-9有没有出现过
    var col: Array[Array[Boolean]] = null // 每一列1-9有没出现过
    var cell: Array[Array[Array[Boolean]]] = null // 每一个方块1-9有没出现过
    // 暴力枚举 + dfs 
    def solveSudoku(board: Array[Array[Char]]): Unit = {
        row = Array.ofDim[Boolean](9, 9)
        col = Array.ofDim[Boolean](9, 9)
        cell = Array.ofDim[Boolean](9, 9, 9)

        // init
        for (i <- 0 until 9; j <- 0 until 9) {
            val v = board(i)(j)
            if (v != '.') {
                val num = v - '1'
                row(i)(num) = true
                col(j)(num) = true
                cell(i / 3)(j / 3)(num) = true
            }
        }

        // dfs, 每个位置枚举每一个1到9
        dfs(board, 0, 0)
    }

    private def dfs(board: Array[Array[Char]], _x: Int, _y: Int): Boolean = {
        var x = _x
        var y = _y
        if (y == 9) {
            // 转到下一行
            x += 1
            y = 0
        }
        if (x == 9) return true
        if (board(x)(y) != '.') return dfs(board, x, y + 1)
        // board(x)(y) 没有数字，枚举1到9
        for (v <- 0 until 9) {
            if (!row(x)(v) && !col(y)(v) && !cell(x / 3)(y / 3)(v)) {
                // 可以放置v，改变状态
                row(x)(v) = true
                col(y)(v) = true
                cell(x / 3)(y / 3)(v) = true
                board(x)(y) = ('1' + v).toChar
                // dfs
                if (dfs(board, x, y + 1)) return true
                //回溯状态
                row(x)(v) = false
                col(y)(v) = false
                cell(x / 3)(y / 3)(v) = false
                board(x)(y) = '.'
            }
        }
        false
    }


}