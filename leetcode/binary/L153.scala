object L153 {
    // 二分大于等于arr(0)的最右端
    def findMin(arr: Array[Int]): Int = {
        var l = 0; var r = arr.length - 1
        val x = arr(0)
        while (l < r) {
            val mid = (l + r + 1) / 2
            if (arr(mid) >= x) {
                l = mid
            } else {
                r = mid - 1
            }
        }
        if (l == arr.length - 1) {
            arr(0)
        } else {
            arr(l + 1)
        }
    }
}