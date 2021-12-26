object Solution {
  // 模拟规则，判断行，列，单个9宫格
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    // 判断行
    val set = collection.mutable.Set[Char]()
    for (i <- 0 until 9) {
      set.clear()
      for (j <- 0 until 9) {
        val v = board(i)(j)
        if (v != '.') {
          if (set.contains(v)) return false
          else set += v
        }
      }
    }

    // 判断列
    for (j <- 0 until 9) {
      set.clear()
      for (i <- 0 until 9) {
        val v = board(i)(j)
        if (v != '.') {
          if (set.contains(v)) return false
          else set += v
        }
      }
    }

    // 判断方格
    for (i <- Array(0, 3, 6)) {
      for (j <- Array(0, 3, 6)) {
        set.clear()
        for (x <- 0 until 3) {
          for (y <- 0 until 3) {
            val v = board(i + x)(j + y)
            if (v != '.') {
              if (set.contains(v)) return false
              else set += v
            }
          }
        }
      }
    }
    true
  }
}