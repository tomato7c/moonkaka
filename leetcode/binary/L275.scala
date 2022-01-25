object Solution {
    def hIndex(citations: Array[Int]): Int = {
        val arr = citations.reverse
        var l = 0; var r = arr.length - 1
        while (l < r) {
            val mid = (l + r + 1) / 2
            if (arr(mid) >= mid + 1) {
                l = mid
            } else {
                r = mid - 1
            }
        }
        if (arr(l) == 0) 0 else l + 1
    }
}
