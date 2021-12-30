object L56 {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    val res = collection.mutable.ListBuffer[Array[Int]]()
    val arr = intervals.sortWith(_(0)<_(0))
    var pre = arr(0)
    for (cur <- arr) {
      if (cur(0) >= pre(0) && cur(0) <= pre(1)) {
        pre(1) = Math.max(pre(1), cur(1))
      } else {
        res += Array[Int](pre(0), pre(1))
        pre = cur
      }
    }
    res += Array[Int](pre(0), pre(1))
    res.toList.toArray
  }
}