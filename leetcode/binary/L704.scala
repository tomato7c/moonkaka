object Solution {
    // 二分 >= target的第一个数
    def search(arr: Array[Int], target: Int): Int = {
        var l = 0; var r = arr.length - 1
        while (l < r) {
            val mid = l + r >>> 1
            if (arr(mid) >= target) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        if (arr(l) == target) l else -1
    }
}