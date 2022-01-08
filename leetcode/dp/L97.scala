// 字符串 线性dp
object L97 {
    // f(i,j)表示 s(i + j)由a的前i个，b的前j个字符交叉出来
    // f(0,0) = true
    // f(i,j) = f(i - 1, j) && a(i) == s(i + j) or f(i, j - 1) && b(j) == s(i + j)
    def isInterleave(_a: String, _b: String, _s: String): Boolean = {
        val a = " " + _a; val b = " " + _b; val s = " " + _s
        val m = _a.length; val n = _b.length
        if (m + n != _s.length) return false
        val f: Array[Array[Boolean]] = Array.ofDim(m  + 1, n + 1)
        f(0)(0) = true

        // init
        for (i <- 1 to m if f(i - 1)(0) && a(i) == s(i)) f(i)(0) = true
        for (j <- 1 to n if f(0)(j - 1) && b(j) == s(j)) f(0)(j) = true

        for (i <- 1 to m; j <- 1 to n) {
            if (f(i - 1)(j) && a(i) == s(i + j) 
            || f(i)(j - 1) && b(j) == s(i + j)) f(i)(j) = true
        }
        f(m)(n)
    }
}