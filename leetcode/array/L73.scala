object L73 {
    // 分别用第一行，第一列标识出对应列/行有没有0
    def setZeroes(matrix: Array[Array[Int]]): Unit = {
        var row = 1; var col = 1
        val m = matrix.length; val n = matrix(0).length
        for (i <- 0 until m if matrix(i)(0) == 0) col = 0
        for (j <- 0 until n if matrix(0)(j) == 0) row = 0 

        // 打标记
        for (i <- 1 until m; j <- 1 until n) {
            if (matrix(i)(j) == 0) {
                matrix(i)(0) = 0
                matrix(0)(j) = 0
            }
        }
        // 根据标记set 0
        for (i <- 1 until m; j <- 1 until n if matrix(i)(0) == 0 || matrix(0)(j) == 0) matrix(i)(j) = 0 

        if (col == 0) { // 第一列存在0
            for (i <- 0 until m) matrix(i)(0) = 0
        }
        if (row == 0) {// 第一行存在0
            for (j <- 0 until n) matrix(0)(j) = 0
        }
    }
}