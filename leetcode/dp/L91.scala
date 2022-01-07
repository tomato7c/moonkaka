object L91 {
    // f(i)表示以s(i)结尾的子串解码方式，则f(i) = Option(f(i - 1)) + Option(f(i - 2))
    // 为避免越界判断，可以在字符串前拼接一个非法字符
    def numDecodings(_s: String): Int = {
        val s = " " + _s
        val f = new Array[Int](s.length)
        f(0) = 1
        for (i <- 1 until s.length) {
            if (s(i) >= '1') f(i) = f(i - 1)
            if (s(i - 1) == '1' || s(i - 1) == '2' && s(i) <= '6') f(i) += f(i - 2)
        }
        f(s.length - 1)
    }
}
