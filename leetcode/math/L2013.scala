class DetectSquares() {

  private var map = collection.Map[String, Int]()

  def add(point: Array[Int]): Unit = {
    val key = toKey(point)
    map += (key -> (map.getOrElse(key, 0) + 1))
  }

  // 枚举当前point的对角线点，如果是对角线，则可以确定四个点位置
  // key1  key2
  // key0  key3
  def count(point: Array[Int]): Int = {
    var res = 0
    val key0 = toKey(point)
    val x0 = point(0); val y0 = point(1)
    for (key2 <- map.keys if !key2.equals(key0)) {
      val point2 = toArray(key2)
      val x2 = point2(0); val y2 = point2(1)
      if (math.abs(x2 - x0) == math.abs(y2 - y0)) {
        val key1 = toKey(Array(x2, y0))
        val key3 = toKey(Array(x0, y2))
        if (map.contains(key1) && map.contains(key3)) {
          res += map(key2) * map(key1) * map(key3)
        }
      }
    }
    res
  }

  private def toKey(point: Array[Int]): String = s"(${point(0)},${point(1)})"

  private def toArray(s: String): Array[Int] = {
    s match {
      case s"($a,$b)" => Array(a.toInt, b.toInt)
    }
  }

}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * var obj = new DetectSquares()
 * obj.add(point)
 * var param_2 = obj.count(point)
 */