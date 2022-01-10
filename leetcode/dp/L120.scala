object L120 {
    def minimumTotal(triangle: List[List[Int]]): Int = {
        val n = triangle.last.size
        val f: Array[Int] = Array.ofDim(n)
        f(0) = triangle(0)(0)

        for (i <- 1 until n) {
            for (j <- (0 to i).reverse) {
                if (j == 0) {
                    f(j) = f(j) + triangle(i)(j)
                } else if (j == i) {
                    f(j) = f(j - 1) + triangle(i)(j)
                } else {
                    f(j) = Math.min(f(j), f(j - 1)) + triangle(i)(j)
                }
            }
        }
        f.min
    }
}