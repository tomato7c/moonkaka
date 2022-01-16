object L1220 {
    /**
    * f(i,0) 表示i + 1个字符，最后一个字符是a的数量; f(i, 1), f(i, 2)...同理
    * f(0, 0 to 4) = 1
    * f(i, 0) = f(i - 1, 1) + f(i - 1, 2) + f(i - 1, 4)
    * f(i, 1) = f(i - 1, 0) + f(i - 1, 2)
    * f(i, 2) = f(i - 1, 1) + f(i - 1, 3)
    * f(i, 3) = f(i - 1, 2)
    * f(i, 4) = f(i - 1, 2) + f(i - 1, 3)
    */
    def countVowelPermutation(n: Int): Int = {
        val f: Array[Array[Long]] = Array.ofDim(n, 5)
        val mod = (1e9 + 7).toInt
        for (i <- 0 until 5) f(0)(i) = 1
        for (i <- 1 until n) {
            f(i)(0) = (f(i - 1)(1) + f(i - 1)(2) + f(i - 1)(4)) % mod
            f(i)(1) = (f(i - 1)(0) + f(i - 1)(2)) % mod
            f(i)(2) = (f(i - 1)(1) + f(i - 1)(3)) % mod
            f(i)(3) = f(i - 1)(2)
            f(i)(4) = (f(i - 1)(2) + f(i - 1)(3)) % mod
        }
        var sum = 0L
        for (i <- 0 until 5) {
            sum += f(n - 1)(i)
            sum %= mod
        }
        sum.toInt
    }
}