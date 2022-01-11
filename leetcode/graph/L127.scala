object L127 {
  // bfs, 本质是无向图中两点之间最短距离; 如果扩散到下一层？替换当前字符串的每一位，如存在则说明是bfs的下一层(同时要维护visited集)
  def ladderLength(begin: String, end: String, wordList: List[String]): Int = {
    val wordSet = collection.mutable.Set.from(wordList)

    if (!wordSet.contains(end)) return 0

    val q = collection.mutable.Queue[String]()
    val visited = collection.mutable.Set[String]()
    q.enqueue(begin);
    visited += begin
    var step = 1
    while (q.nonEmpty) {
      val levelSize = q.size
      for (temp <- 0 until levelSize) {
        val cur = q.dequeue()
        if (replaceAndEnqueue(cur, end, wordSet, visited, q)) {
          step += 1
          return step
        }
      }
      step += 1
    }

    0
  }

  private def replaceAndEnqueue(cur: String, end: String, wordSet: collection.mutable.Set[String],
                              visited: collection.mutable.Set[String], q: collection.mutable.Queue[String]): Boolean = {
    val arr = cur.toArray
    for (i <- arr.indices) {
      val origin = arr(i)
      for (c <- 'a' to 'z' if c != origin) {
        arr(i) = c
        val w = new String(arr)
        if (wordSet.contains(w)) {
          if (w.equals(end)) return true
          if (!visited.contains(w)) {
            visited += w
            q.enqueue(w)
          }
        }
      }
      arr(i) = origin
    }
    false
  }
}