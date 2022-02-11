object Solution {
    // 二段性：假设窗口为[i,j], 当j向右移动时，必然导致窗口内字符种类不边或增加
    // 当i向右移动时，必然导致窗口内字符种类不变或减少
    def longestSubstring(s: String, k: Int): Int = {
        var res = 0
        for (size <- 1 to 26) {
            var c_count = 0 // 窗口内字符种类
            var c_candidate = 0 // 窗口内满足条件(>k)的种类
            val hash = new Array[Int](256)
            var i = 0
            for (j <- s.indices) {
                // add
                val c = s(j)
                if (hash(c) == 0) c_count += 1
                hash(c) += 1
                if (hash(c) == k) c_candidate += 1

                // del
                while (c_count > size) {
                    val d = s(i)
                    if (hash(d) == k) c_candidate -= 1
                    if (hash(d) == 1) c_count -= 1
                    hash(d) -= 1
                    i += 1
                }
                if (c_count == c_candidate) res = res.max(j - i + 1)
            }
        }
        res
    }
}