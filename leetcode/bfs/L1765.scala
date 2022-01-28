object Solution {
    val vectors = Array((1, 0), (-1, 0), (0, -1), (0, 1))
    // 多源bfs, 当前层高度取前一层 + 1, 每个位置只赋值一次
    def highestPeak(isWater: Array[Array[Int]]): Array[Array[Int]] = {
        val m = isWater.length; val n = isWater(0).length
        val arr: Array[Array[Int]] = Array.ofDim(m, n)
        val q = collection.mutable.Queue[(Int, Int)]()
        // init 水域初始化为0，陆地为-1
        for (i <- 0 until m; j <- 0 until n) {
            if (isWater(i)(j) == 1) {
                q.enqueue((i, j))
            } else {
                arr(i)(j) = -1
            }
        }
        while (q.nonEmpty) {
            val size = q.size
            for (temp <- 0 until size) {
                val t = q.dequeue
                val value = arr(t._1)(t._2)
                for (v <- vectors) {
                    val x = t._1 + v._1; val y = t._2 + v._2
                    if (x >= 0 && x < m && y >= 0 && y < n && arr(x)(y) == -1) {
                        arr(x)(y) = value + 1
                        q.enqueue((x, y))
                    }
                }
            }
        }
        arr
    }
}