class Solution(_w: Array[Int]) {

    val arr = new Array[Int](_w.length)
    arr(0) = _w(0)
    for (i <- 1 until _w.length) arr(i) = arr(i - 1) + _w(i)

    // 1,2,2 => 1,3,5
    // 二分前缀和数组中 >= random的第一个位置
    def pickIndex(): Int = {
        val random = util.Random.nextInt(arr.last) + 1

        var l = 0; var r = arr.length - 1
        while (l < r) {
            val mid = l + r >>> 1
            if (arr(mid) >= random) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        l
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */