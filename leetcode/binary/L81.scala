object L81 {
    // 就怕arr(0)有重复...
    def search(arr: Array[Int], target: Int): Boolean = {
        var l = 0; var r = arr.length - 1
        while (l + 1 < arr.length && arr(l + 1) == arr(0)) l += 1
        while (r >= 0 && arr(r) == arr(0)) r -= 1
        // 找到>= arr(0)的最后一个数
        while (l < r) {
            val mid = l + r + 1 >>> 1
            if (arr(mid) >= arr(0)) {
                l = mid
            } else {
                r = mid - 1
            }
        }
        if (target == arr(l)) return true
        if (target < arr(0)) {
            l = l + 1
            r = arr.length - 1
        } else {
            r = l
            l = 0
        }
        // 找到 >= target的第一个数
        while (l < r) {
            val mid = l + r >>> 1
            if (arr(mid) >= target) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        if (l < arr.length) arr(l) == target else false
    }
}