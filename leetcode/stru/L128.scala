object L128 {
  // 有点trick, 借助set,分别递增查找
  def longestConsecutive(arr: Array[Int]): Int = {
    var res = 0
    val set = collection.mutable.Set.from(arr)
    for (_v <- arr if !set.contains(_v - 1)) {
      var count = 0; var v = _v
      while (set.contains(v)) {
          count += 1
          v += 1
      }
      res = Math.max(res, count)
    }
    res
  }
}