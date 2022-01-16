object L152 {
    // 乘法的特殊性质 => 负负得正，如果arr(i)是一个负数，则期望乘上arr(i - 1)为端点的集合中最小的负数
    def maxProduct(arr: Array[Int]): Int = {
        val n = arr.length
        val f, g = new Array[Int](n)
        f(0) = arr(0); g(0) = arr(0)
        for (i <- 1 until n) {
            val v = arr(i)
            if (v >= 0) {
                f(i) = Math.max(v, v * f(i - 1))
                g(i) = Math.min(v, v * g(i - 1))
            } else {
                f(i) = Math.max(v, v * g(i - 1))
                g(i) = Math.min(v, v * f(i - 1))
            }
        }
        f.max
    }
}