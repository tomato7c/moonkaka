// 双指针，排除法
object L11 {

  def main(args: Array[String]): Unit = {
    assert(maxArea(Array(4, 3, 2, 1, 4)) == 16)
    assert(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
  }

  // 暴力枚举的话是C(n, 2), 实际上可以通过排除法确定指针移动策略
  def maxArea(height: Array[Int]): Int = {
    var res = 0
    var l = 0
    var r = height.length - 1
    while (l < r) {
      res = Math.max(res, Math.min(height(l), height(r)) * (r - l))
      // continue
      if (height(l) <= height(r)) l += 1 else r -= 1
    }
    res
  }
}