object L198 {
    // f(i)表示走过前i间，且偷第间房子的最大总金额
    def rob(arr: Array[Int]): Int = {
        val n = arr.length
        if (n == 1) return arr(0)
        
        val f = new Array[Int](n + 1)
        f(0) = 0; f(1) = arr(0)
        for (i <- 2 to n) {
            f(i) = Math.max(f(i - 1), f(i - 2) + arr(i - 1))
        }
        Math.max(f(n), f(n - 1))
    }
}