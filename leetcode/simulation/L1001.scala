import scala.collection.mutable
object Solution {

    private var n = -1
    var row: mutable.Map[Int, Int] = null
    var col: mutable.Map[Int, Int] = null
    var left: mutable.Map[Int, Int] = null
    var right: mutable.Map[Int, Int] = null
    var lampset: mutable.Set[(Int, Int)] = null

    private val vectors = Array((-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1), (0, 0))
    // (x, y) x表示行，y表示列，x + y, x - y表示对角线
    // 某个位置亮的条件是，满足x或y或x + y或x - y
    // 因为某个位置可以重复被照亮，需要统计该行/列/对角线的count
    def gridIllumination(_n: Int, lamps: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
        n = _n
        row = mutable.Map[Int, Int](); col = mutable.Map[Int, Int]()
        left = mutable.Map[Int, Int](); right = mutable.Map[Int, Int]() // left = x - y; right = x + y
        lampset = mutable.Set[(Int, Int)]() // 保存灯位置
        // turn on
        for (lamp <- lamps) {
            val x = lamp(0); val y = lamp(1)
            // 同一个灯泡只开一次
            if (!lampset.contains((x, y))) turnOn(x, y)
        }

        val res = mutable.ListBuffer[Int]()
        // query and turn off
        for (query <- queries) {
            val x = query(0); val y = query(1)
            if (isLight(x, y)) {
                res += 1
                turnOff(x, y)
            } else {
                res += 0
            }
        }
        res.toArray
    }
    // 当前位置是否被点亮
    private def isLight(x: Int, y: Int): Boolean = {
        if (row.contains(x) && row(x) > 0) return true
        if (col.contains(y) && col(y) > 0) return true
        if (left.contains(x - y) && left(x - y) > 0) return true
        if (right.contains(x + y) && right(x + y) > 0) return true
        false
    }

    // 关闭(a,b)及周围的灯泡(如果存在的话)
    private def turnOff(a: Int, b: Int) {
        def inMatrix(x: Int, y: Int): Boolean = x >= 0 && x < n && y >= 0 && y < n
        for ((dx, dy) <- vectors) {
            val x = a + dx; val y = b + dy
            val point = (x, y)
            if (inMatrix(x, y) && lampset.contains(point)) {
                // 行/列/对角线的”光覆盖量“减1
                row(x) -= 1; col(y) -= 1
                left(x - y) -= 1; right(x + y) -= 1
                lampset -= point
            }
        }
    }
    // 打开(x,y)位置的灯泡
    private def turnOn(x: Int, y: Int) {
        if (!row.contains(x)) row(x) = 1 else row(x) += 1
        if (!col.contains(y)) col(y) = 1 else col(y) += 1
        val l = x - y
        if (!left.contains(l)) left(l) = 1 else left(l) += 1
        val r = x + y
        if (!right.contains(r)) right(r) = 1 else right(r) += 1
        lampset.addOne((x, y))
    }
}