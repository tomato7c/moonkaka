object Solution {
    // 因为要保证i,j顺序，需要在统计频率时计算方案数
    def countKDifference(arr: Array[Int], k: Int): Int = {
        val count = new Array[Int](101)
        var res = 0
        for (v <- arr) {
            res += safeIndex(count, v - k)
            res += safeIndex(count, v + k)
            count(v) += 1
        }
        res
    }

    private def safeIndex(arr: Array[Int], index: Int): Int = {
        val n = arr.length
        if (index >= 0 && index < n) arr(index) else 0
    }
}