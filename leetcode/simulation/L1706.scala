import scala.util.control.Breaks.{break, breakable}
object Solution {
    def findBall(grid: Array[Array[Int]]): Array[Int] = {
        val m = grid.length; val n = grid(0).length
        val res = new Array[Int](n)

        for (j <- 0 until n) {
            def getPosition(_x: Int, _y: Int): Int = {
                var row = _x; var col = _y
                while (row < m) {
                    val nextCol = col + grid(row)(col)
                    if (nextCol < 0 || nextCol >= n) return -1
                    if (grid(row)(col) != grid(row)(nextCol)) return -1
                    row += 1; col = nextCol
                }
                col
            }
            res(j) = getPosition(0, j)
        }
        res
    }
}