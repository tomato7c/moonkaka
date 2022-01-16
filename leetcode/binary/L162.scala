object L162 {
    // 二分递减序列的最左值
    def findPeakElement(arr: Array[Int]): Int = {
        var l = 0; var r = arr.length - 1
        while (l < r) {
            val mid = (l + r) / 2
            if (arr(mid) > arr(mid + 1)) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        l
    }
}