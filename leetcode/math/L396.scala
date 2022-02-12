object Solution {
    // 画图归纳
    // f(1) - f(0) = sum - n*a(n - 1)
    // f(2) - f(1) = sum - n*a(n - 2)
    def maxRotateFunction(arr: Array[Int]): Int = {
        val N = arr.length
        val SUM = arr.sum
        var cur = 0
        for (i <- arr.indices) cur += i * arr(i)
        var max = cur
        for (k <- 1 to N - 1) {
            cur += SUM - N * arr(arr.length - k)
            max = math.max(max, cur)
        }
        max
    }
}