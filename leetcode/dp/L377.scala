object Solution {
    // f(i,j)表示前i个位置，组合成j的方案数, 枚举最后一个数的可选方案
    // f(i,j) = f(i - 1,j - k)
    def combinationSum4(arr: Array[Int], target: Int): Int = {
        val dp: Array[Array[Int]] = Array.ofDim(target + 1, target + 1)
        dp(0)(0) = 1
        
        for (i <- 1 to target; j <- 0 to target) {
            for (v <- arr if j >= v) dp(i)(j) += dp(i - 1)(j - v)
        }
        var res = 0
        for (i <- 1 to target) res += dp(i)(target)
        res
    }

    // f(i)表示凑成总和i的方案数
    // f(i) += f(i - k)
    def combinationSum4(arr: Array[Int], target: Int): Int = {
        val dp = new Array[Int](target + 1)
        dp(0) = 1
        for (i <- 1 to target) {
            for (v <- arr if i >= v) dp(i) += dp(i - v)
        }
        dp(target)
    }
}