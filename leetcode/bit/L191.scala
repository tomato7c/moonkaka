object Solution {
    // you need treat n as an unsigned value
    def hammingWeight_v1(_n: Int): Int = {
        var res = 0
        var n = _n
        for (temp <- 0 until 32) {
            if ((n & 1) == 1) res += 1
            n >>>= 1
        }
        res
    }
    def hammingWeight_v2(_n: Int): Int = {
        var res = 0
        var n = _n
        while (n != 0) {
            n &= (n - 1)
            res += 1
        }
        res
    }
}
