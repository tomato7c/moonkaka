object Solution {
    def luckyNumbers (matrix: Array[Array[Int]]): List[Int] = {
        val m = matrix.length; val n = matrix(0).length
        val row = new Array[Int](m)
        val col = new Array[Int](n)
        for (i <- 0 until m) {
            row(i) = Int.MaxValue
            for (j <- 0 until n) {
                row(i) = row(i).min(matrix(i)(j))
                col(j) = col(j).max(matrix(i)(j))
            }
        }
        val res = collection.mutable.ListBuffer[Int]()
        for (i <- 0 until m; j <- 0 until n) {
            val t = matrix(i)(j)
            if (t == row(i) && t == col(j)) res += t
        }
        res.toList
    }
}