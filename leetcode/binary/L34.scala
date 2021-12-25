object L34 {
    // 找到>=target的第一个数，<= target的最后一个数
    def searchRange(arr: Array[Int], target: Int): Array[Int] = {
        if (arr.length < 1) return Array(-1, -1)
        var l = 0
        var r = arr.length - 1
        while (l < r) {
            val mid = l + r >>> 1
            if (arr(mid) >= target) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        if (arr(l) != target) return Array(-1, -1)
        val first = l

        l = 0
        r = arr.length - 1
        while (l < r) {
            val mid = l + r + 1 >>> 1
            if (arr(mid) <= target) {
                l = mid
            } else {
                r = mid - 1
            }
        }
        return Array(first, l)
    }
}