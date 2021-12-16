object L16 {

  def main(args: Array[String]): Unit = {
    assert(threeSumClosest(Array(-1, 2, 1, -4), 1) == 2)
    assert(threeSumClosest(Array(0, 0, 0), 1) == 0)
  }
  
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    val arr = nums.sortWith(_<_)
    var min = arr(0) + arr(1) + arr(2)
    for (i <- arr.indices) {
      var l = i + 1
      var r = arr.length - 1
      while (l < r) {
        val sum = arr(i) + arr(l) + arr(r)
        if (Math.abs(sum - target) < Math.abs(min - target)) min = sum
        // continue
        if (sum == target) {
          return sum
        } else if (sum > target) {
          r -= 1
        } else {
          l += 1
        }
      }
    }
    min
  }
}