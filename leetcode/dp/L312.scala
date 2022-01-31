object Solution {
    // f(i,j)表示将区间(i,j)开区间!!!,气球打完的所有方案中，取分数最大值
    // 状态计算： 按照最后一次打气球的位置来划分i+1, i+2, i+3... until j
    // f(i,j) = f(i,k) + hit(k) + f(k,j)
    def maxCoins(nums: Array[Int]): Int = {
        val n = nums.length
        val arr = new Array[Int](n + 2)
        arr(0) = 1; arr(arr.length - 1) = 1
        for (i <- 1 to n) arr(i) = nums(i - 1)

        val dp: Array[Array[Int]] = Array.ofDim(n + 2, n + 2)

        for (window <- 3 to n + 2) { // 窗口大小，窗口为2时没有答案(因为是开区间)
            for (i <- 0 to n + 2 - window) { // j <= i + window - 1 且j最大值为n + 1
                val j = i + window -1
                for (k <- i + 1 to j - 1) {
                    val candidate = arr(i) * arr(k) * arr(j)
                    dp(i)(j) = dp(i)(j).max(dp(i)(k) + candidate + dp(k)(j))
                }
            }
        }
        dp(0)(n + 1)
    }
}