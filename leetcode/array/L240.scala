object Solution {
    def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
        val m = matrix.length; val n = matrix(0).length
        var i = 0; var j = n - 1
        while (i < m && j >= 0) {
            val v = matrix(i)(j)
            if (v == target) {
                return true
            } else if (v > target) {
                j -= 1
            } else {
                // v < target
                i += 1
            }
        }
        false
    }
}