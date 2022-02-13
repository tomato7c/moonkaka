object Solution {
    // 偶=奇 x 奇=偶
    // 二分 偶=奇的最左边界
    def singleNonDuplicate(arr: Array[Int]): Int = {
        var l = 0; var r = arr.length - 1
        while (l < r) {
            val mid = l + r >>> 1
            if (check(arr, mid)) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        arr(l)
    }

    private def check(arr: Array[Int], mid: Int): Boolean = {
        if (mid % 2 == 0) {
            arr(mid) == arr(mid + 1)
        } else {
            arr(mid) == arr(mid - 1)
        }
    }
}