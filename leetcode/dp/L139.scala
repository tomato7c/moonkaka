object L139 {
    // inDict(i)(j)表示s(i) to s(j)这个单词在词典内; 区间dp
    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        val n = s.length
        val inDict: Array[Array[Boolean]] = Array.ofDim(n, n)
        // init
        for (i <- 0 until n; j <- i until n if wordDict.contains(s.substring(i, j + 1))) inDict(i)(j) = true

        val f = new Array[Boolean](n)
        for (i <- 0 until n; mid <- 0 to i if !f(i)) {
            if (mid == 0) {
                if (inDict(mid)(i)) f(i) = true
            } else {
                if (f(mid - 1) && inDict(mid)(i)) f(i) = true
            }
        }
        f.last
    }
}