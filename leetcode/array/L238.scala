object L238 {
    // 前缀积 * 后缀积，画图容易想清楚
    def productExceptSelf(arr: Array[Int]): Array[Int] = {
        val n = arr.length
        val res = new Array[Int](n)
        var pre = 1

        for (i <- arr.indices) {
            res(i) = pre
            pre *= arr(i)
        }
        var post = 1
        for (i <- arr.indices.reverse) {
            res(i) *= post
            post *= arr(i)
        }
        res
    }
}