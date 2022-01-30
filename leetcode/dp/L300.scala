object Solution {
    // f(i) 表示以arr(i)结尾的最长递增子序列长度
    def lengthOfLIS(arr: Array[Int]): Int = {
        val dp = new Array[Int](arr.length)
        dp(0) = 1
        for (i <- 1 until arr.length; j <- 0 until i) {
            if (arr(i) > arr(j)) {
                dp(i) = math.max(dp(i), dp(j) + 1)
            } else {
                dp(i) = math.max(dp(i), 1)
            }
        }
        dp.max
    }
}