import scala.util.control.Breaks.{break, breakable}
object Solution {

    val vectors = Array((1, 0), (-1, 0), (0, 1), (0, -1))

    def numEnclaves(grid: Array[Array[Int]]): Int = {
        val m = grid.length; val n = grid(0).length
        val q = collection.mutable.Queue[(Int, Int)]()
        def inRange(x: Int, y: Int): Boolean = x >= 0 && x < m && y >= 0 && y < n

        for (i <- 0 until m; j <- 0 until n) {
            if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid(i)(j) == 1) q.enqueue((i, j))
        }
        while (q.nonEmpty) {
            val size = q.size
            for (temp <- 0 until size) {
                breakable({
                    val (a, b) = q.dequeue
                    if (grid(a)(b) == 0) break
                    grid(a)(b) = 0
                    for ((dx, dy) <- vectors) {
                        val x = a + dx; val y = b + dy
                        if (inRange(x, y) && grid(x)(y) == 1) q.enqueue((x, y))
                    }
                })
            }
        }
        var res = 0
        for (i <- 0 until m; j <- 0 until n if grid(i)(j) == 1) res += 1
        res
    }
}