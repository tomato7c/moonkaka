object L149 {
    // 枚举a,b点组成的直线斜率是否与b,c直线相等
    // (a.y - b.y)/(a.x - b.x) = (b.y - c.y)/(b.x - c.x) => (a.y - b.y) * (b.x - c.x) = (b.y - c.y) * (a.x - b.x) 
    def maxPoints(points: Array[Array[Int]]): Int = {
        val n = points.length
        var res = 1
        for (i <- 0 until n; j <- i + 1 until n) {
            val a = points(i); val b = points(j)
            var count = 2
            for (k <- j + 1 until n) {
                val c = points(k)
                val s1 = (a(1) - b(1)) * (b(0) - c(0))
                val s2 = (b(1) - c(1)) * (a(0) - b(0))
                if (s1 == s2) count += 1
            }
            res = Math.max(res, count)
        }
        res
    }
}