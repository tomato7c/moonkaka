object Solution {
    // 最长上升子序列, f(i)表示以index.i结尾的信封组成的最多信封
    def maxEnvelopes(_envelopes: Array[Array[Int]]): Int = {
        val envelopes = _envelopes.sortWith(_(0)<_(0))
        def canEnvelop(inner: Int, outer: Int): Boolean = {
            envelopes(inner)(0) < envelopes(outer)(0) && envelopes(inner)(1) < envelopes(outer)(1)
        }
        val dp = new Array[Int](envelopes.length)
        for (i <- dp.indices) dp(i) = 1
        for (i <- dp.indices) {
            for (j <- 0 until i if canEnvelop(j, i)) {
                dp(i) = dp(i).max(dp(j) + 1)
            }
        }
        dp.max
    }
    // 傻逼leetcode，用二分也超时
    def maxEnvelopes(envelopes: Array[Array[Int]]): Int = {
        // 按宽度递增，高度递减
        val arr = envelopes.sortWith((a, b) => {
            if (a(0) == b(0)) a(1) > b(1) else a(0) < b(0)
        })
        val dp = collection.mutable.ListBuffer[Int]() // dp(i)的含义为前x个元素组成长度(i + 1)时的子序列最末端高度，的最小值
        dp += arr(0)(1)
        for (i <- 1 until arr.length) {
            val newH = arr(i)(1)
            if (newH > dp(dp.size - 1)) {
                dp += arr(i)(1)
            } else {
                // 当前高度 < 当前最外层高度
                // 找到高度第一个大于newH的，直接替换
                var l = 0; var r = dp.size - 1
                while (l < r) {
                    val m = l + r >>> 1
                    if (dp(m) >= newH) {
                        r = m
                    } else {
                        l = m + 1
                    }
                }
                dp(l) = newH
            }
        }
        dp.size
    }
}