object L154 {
    // 按照arr(0)去重后再二分 >= arr(0)的最右端
    def findMin(arr: Array[Int]): Int = {
        val x = arr(0)
        var l = 0; var r = arr.length - 1
        while (l + 1 < r && arr(l + 1) == x) l += 1
        while (r > l && arr(r) == x) r -= 1
        val end = r
        while (l < r) {
            val mid = (l + r + 1) / 2
            if (arr(mid) >= x) {
                l = mid
            } else {
                r = mid - 1
            }
        }
        if (l == end) {
            arr(0)
        } else {
            arr(l + 1)
        }
    }
}