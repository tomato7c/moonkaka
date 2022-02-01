object Solution {
    // 使用 % / 转换进制，难点是要处理负数，把负数的二进制当成long类型下正数来计算，可以通过加上2^32来实现
    def toHex(num: Int): String = {
        var remain: Long = num
        if (remain < 0) remain += math.pow(2, 32).toLong
        val res = new StringBuilder()
        val map = "0123456789abcdef"
        while (remain > 0) {
            res.append(map((remain % 16).toInt))
            remain /= 16
        }
        if (res.isEmpty) "0" else res.reverse.toString
    }

        // 分组
    def toHex_v2(num: Int): String = {
        val map = "0123456789abcdef"
        val res = new StringBuilder
        var remain = num
        while (remain != 0) {
            res.append(map(remain & 15))
            remain >>>= 4
        }
        if (res.isEmpty) "0" else res.reverse.toString
    }
}