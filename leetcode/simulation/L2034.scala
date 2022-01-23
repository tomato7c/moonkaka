// 模拟，用treemap维护最大，最小price， curTimestamp维护最大时间戳，map维护时间戳到价格的映射
class StockPrice() {

  private var curTimeStamp = -1

  private var treeMap = collection.mutable.TreeMap[Int, Int]() // price -> count

  private var map = collection.mutable.Map[Int, Int]()

  def update(timestamp: Int, price: Int): Unit = {
    curTimeStamp = curTimeStamp.max(timestamp)
    if (map.contains(timestamp)) {
      val oldVal = map(timestamp)
      val count = treeMap(oldVal)
      if (count == 1) treeMap -= oldVal
      else treeMap += (oldVal -> (count - 1))
    }
    map += (timestamp -> price)
    treeMap += (price -> (treeMap.getOrElse(price, 0) + 1))
  }

  def current(): Int = {
    map(curTimeStamp)
  }

  def maximum(): Int = {
    treeMap.lastKey
  }

  def minimum(): Int = {
    treeMap.firstKey
  }

}

/**
 * Your StockPrice object will be instantiated and called as such:
 * var obj = new StockPrice()
 * obj.update(timestamp,price)
 * var param_2 = obj.current()
 * var param_3 = obj.maximum()
 * var param_4 = obj.minimum()
 */