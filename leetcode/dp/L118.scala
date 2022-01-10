object L118 {
    def generate(n: Int): List[List[Int]] = {
        val res = collection.mutable.ListBuffer[List[Int]]()
        val arr: Array[Array[Int]] = Array.ofDim(n, n)
        for (i <- 0 until n) {
            arr(i)(0) = 1
            arr(i)(i) = 1
        }
        for (i <- 0 until n) {
            for (j <- 1 until i) {
                arr(i)(j) = arr(i - 1)(j - 1) + arr(i - 1)(j)
            }
            res += arr(i).take(i + 1).toList
        }
        res.toList
    }
}