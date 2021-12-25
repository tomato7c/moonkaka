object L33 {

  def main(args: Array[String]): Unit = {
    assert(search(Array(4,5,6,7,0,1,2), 0) == 4)
    assert(search(Array(1), 0) == -1)
  }

  // 二分出旋转的点，即 >= arr(0)的最后一个点；再根据target在哪个区间二分，二分出>=target的第一个点
  def search(arr: Array[Int], target: Int): Int = {
    if (arr.isEmpty) return -1
    var l = 0
    var r = arr.length - 1
    while (l < r) {
      val mid = l + r + 1 >>> 1
      if (arr(mid) >= arr(0)) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    if (target < arr(0)) {
      l = r + 1
      r = arr.length - 1
    } else {
      r = l
      l = 0
    }

    while (l < r) {
      val mid = l + r >>> 1
      if (arr(mid) >= target) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    if (l > arr.length - 1 || arr(l) != target) return -1
    l
  }
}