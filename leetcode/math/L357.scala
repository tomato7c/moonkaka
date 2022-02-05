object Solution {
    // 9 9 8 7 6 5 4 3 2 1
    // 模拟每一位可以放哪些数 加上特判的0
    def countNumbersWithUniqueDigits(_n: Int): Int = {
        val n = _n.min(10)
        if (n == 0) return 1
        val f = new Array[Int](n + 1)
        f(1) = 9
        for (i <- 2 to n) f(i) = f(i - 1) * (11 - i)
        f.sum + 1 // 加上0
    }
}