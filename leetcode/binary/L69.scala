object L69 {
    // TODO 带精度的sqrt
    // 找到 a^2 <= x 的最后一个数
    def mySqrt(x: Int): Int = {
        if (x == 0) return 0
        var l = 1; var r = x
        while (l < r) {
            val mid = l + r + 1 >>> 1
            if (mid <= x / mid) {
                l = mid
            } else {
                r = mid - 1
            }
        }
        l
    }
}