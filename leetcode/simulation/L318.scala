object Solution {
    // 使用位运算快速比较两个字符串是否相交
    def maxProduct(words: Array[String]): Int = {
        val n = words.length
        var res = 0
        val mask = new Array[Int](words.length)
        for (i <- words.indices) mask(i) = toInt(words(i))

        for (i <- 0 until n; j <- i + 1 until n) {
            if ((mask(i) & mask(j)) == 0) res = res.max(words(i).length * words(j).length)
        }
        res
    }

    private def toInt(s: String): Int = {
        var res = 0
        for (c <- s) {
            val diff = c - 'a'
            res |= 1 << diff
        }
        res
    }
}