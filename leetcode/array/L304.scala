class NumMatrix(_matrix: Array[Array[Int]]) {

    var arr: Array[Array[Int]] = null

    {   // 前缀和 f(i,j) = f(i - 1, j) + f(i, j - 1) - f(i - 1, j - 1) + cur
        arr = Array.ofDim(_matrix.length + 1, _matrix(0).length + 1)
        // init
        for (i <- 1 to _matrix.length; j <- 1 to _matrix(0).length) {
            arr(i)(j) = arr(i - 1)(j) + arr(i)(j - 1) - arr(i - 1)(j - 1) + _matrix(i - 1)(j - 1)
        }
    }

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
        val a = row1 + 1; val b = col1 + 1; val c = row2 + 1; val d = col2 + 1

        arr(c)(d) - arr(a - 1)(d) - arr(c)(b - 1) + arr(a - 1)(b - 1)
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */