object L53 {
    // f(i)表示以i结尾的最大子数组和
    // f(i) = max(f(i - 1) + f(i), f(i))
    def maxSubArray(arr: Array[Int]): Int = {
        if (arr.length < 1) return 0
        val f: Array[Int] = Array.ofDim(arr.length)
        f(0) = arr(0)
        var res = f(0)
        for (index <- 1 until arr.length) {
            f(index) = Math.max(f(index - 1) + arr(index), arr(index))
            res = Math.max(res, f(index))
        }
        res
    }

    // f(i)表示以i结尾的最大子数组和
    // f(i) = max(f(i - 1) + f(i), f(i))
    def maxSubArray(arr: Array[Int]): Int = {
        var last = 0
        var res = Int.MinValue
        for (v <- arr) {
            last = v + Math.max(last, 0)
            res = Math.max(res, last)
        }
        res
    }
}