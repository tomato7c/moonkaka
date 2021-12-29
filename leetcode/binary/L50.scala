// 快速幂
object L50 {
    // 快速幂;eg 5 = 101 = 2^0 + 2^2
    def myPow(_x: Double, _n: Int): Double = {
        val isPositive = _n < 0
        var x = _x
        var res: Double = 1
        var n = Math.abs(_n.toLong)
        while (n > 0) {
            if ((n & 1) == 1) res *= x
            x *= x
            n = n >>> 1
        }
        if (isPositive) 1/res else res
    }
}