object L119 {
    def getRow(rowIndex: Int): List[Int] = {
        val arr: Array[Int] = Array.ofDim(rowIndex + 1)
        for (i <- arr.indices) arr(i) = 1

        for (i <- 2 until arr.length) {
            for (j <- (1 until i).reverse) {
                arr(j) = arr(j) + arr(j - 1)
            }
        }
        arr.toList
    }
}