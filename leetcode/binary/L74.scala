object L74 {
    // 蛇形递增。可以等价成0 to m*n的下标索引; 二维转一维，使用二分查找
    // 找到 >= target的最左边数字
    def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
        val m = matrix.length; val n = matrix(0).length
        var l = 0; var r = m * n - 1
        while (l < r) {
            val mid = l + r >>> 1
            val v = matrix(mid / n)(mid % n)
            if (v >= target) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        matrix(l / n)(l % n) == target
    }
}