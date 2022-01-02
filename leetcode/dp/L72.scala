object L72 {
    // f(i)(j)表示从word1的前i个编辑到word2前j个需要的次数
    // 1. 如果走insert方式，为f(i)(j - 1) + 1
    // 2. 走delete方式，f()i - 1(j) + 1
    // 3 replace  f(i - 1)(j - 1) + 0/1
    def minDistance(word1: String, word2: String): Int = {
        val m = word1.length; val n = word2.length
        val a = " " + word1; val b = " " + word2
        val f: Array[Array[Int]] = Array.ofDim(m + 1, n + 1)
        for (i <- 0 to m) f(i)(0) = i // delete
        for (j <- 0 to n) f(0)(j) = j // insert

        for (i <- 1 to m; j <- 1 to n) {
            val insert = f(i)(j - 1) + 1
            val delete = f(i - 1)(j) + 1
            val t = if (a(i) == b(j)) 0 else 1
            val replace = f(i - 1)(j - 1) + t
            f(i)(j) = Math.min(Math.min(insert, delete), replace)
        }
        f(m)(n)
    }
}