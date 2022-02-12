object Solution {
    // 二分count >= k的最左位置
    def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
        var l = matrix(0)(0); var r = matrix.last.last
        while (l < r) {
            val mid = ((l + r).toLong >> 1).toInt // 负数不能用l + r >>> 1，惨
            if (countSmallThan(matrix, mid) >= k) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        l
    }

    private def countSmallThan(matrix: Array[Array[Int]], value: Int): Int = {
        var i = matrix.length - 1
        var res = 0
        for (j <- matrix(0).indices) {
            while (i >= 0 && matrix(j)(i) > value) i -= 1
            res += i + 1
        }
        res
    }
}