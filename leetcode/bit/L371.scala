object Solution {
    // 分情况讨论
    def getSum_v1(a: Int, b: Int): Int = {
        var res = 0
        var t = 0
        for (i <- 0 to 31) {
            val u1 = (a >> i) & 1; val u2 = (b >> i) & 1
            if ((u1 & u2) == 1) {
                // 当前位取决于进位t
                res |= t << i
                t = 1
            } else if ((u1 ^ u2) == 1) {
                // 当前位取决于t,如果t是1，当前位是0，否则是1
                res |= (1 ^ t) << i
                //t = 1 & t
            } else {
                // 当前位为t
                res |= t << i
                t = 0
            }
        }
        res
    }
    // 计算方式可以想象成两步骤， 先异或，再加上进位
    def getSum_v2(a: Int, b: Int): Int = {
        if (b == 0) return a
        getSum(a ^ b, (a & b) << 1)
    }
}