object L35 {

  def main(args: Array[String]): Unit = {
    assert(searchInsert(Array(1, 3, 5, 6), 5) == 2)
    assert(searchInsert(Array(1, 3, 5, 6), 2) == 1)
    assert(searchInsert(Array(1, 3, 5, 6), 7) == 4)
  }

  // 找到 >= taregt的第一个位置
  def searchInsert(arr: Array[Int], target: Int): Int = {
    if (arr.length < 1) return 0
    if (arr(arr.length - 1) < target) return arr.length
    var l = 0
    var r = arr.length - 1
    while (l < r) {
      val mid = l + r >>> 1
      if (arr(mid) >= target) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    l
  }
}