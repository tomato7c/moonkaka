object Solution {
    // 6,5,3,1,0
    def hIndex(citations: Array[Int]): Int = {
        val arr = citations.sortWith(_>_)
        var res = 0
        for (i <- arr.indices if arr(i) >= i + 1) res += 1
        res
    }
}
