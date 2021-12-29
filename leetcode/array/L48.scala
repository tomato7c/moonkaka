// 与联调k-group反转一样，都是通过组合不同的操作实现
object L48 {
    // 按1,5,9对角线翻转，相当于-90 + 一次镜像；再左右翻转，相当于+180度，一次镜像
    def rotate(matrix: Array[Array[Int]]): Unit = {
        if (matrix.length < 1) return
        for (i <- matrix.indices; j <- 0 until i) {
            val temp = matrix(i)(j)
            matrix(i)(j) = matrix(j)(i)
            matrix(j)(i) = temp
        }

        for (row <- matrix.indices) {
            var l = 0
            var r = matrix(row).length - 1
            while (l < r) {
                val temp = matrix(row)(l)
                matrix(row)(l) = matrix(row)(r)
                matrix(row)(r) = temp
                l += 1
                r -= 1
            }
        }
    }
}