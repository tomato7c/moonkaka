object L213 {
    //  dp + 分治；eg [1, 9] 可以拆分为 [1,8],[2,9]两个子问题
    def rob(arr: Array[Int]): Int = {
        if (arr.length == 1) return arr(0)
        robRange(arr, 0, arr.length - 2).max(robRange(arr, 1, arr.length - 1))
    }

    private def robRange(arr: Array[Int], begin: Int, end: Int): Int = {
        if (begin > end) return 0
        var preMax, curMax = 0 // curMax表示考虑当前位置(可能偷，可能不偷)的最大值，preMax表示绝对不偷当前位置时的最大值
        for (i <- begin to end) {
            val temp = curMax
            curMax = curMax.max(preMax + arr(i)) 
            preMax = temp
        }
        curMax
    }
}