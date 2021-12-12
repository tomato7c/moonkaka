object L7 {

  def main(args: Array[String]): Unit = {
    assert(reverse2(0) == 0)
    assert(reverse2(555) == 555)
    assert(reverse2(456) == 654)
    assert(reverse2(-123) == -321)
    assert(reverse2(Int.MinValue) == 0)
    assert(reverse2(Int.MaxValue) == 0)
    assert(reverse2(2147483645) == 0)
  }

  /**
   * 如果允许使用64bit
   */
  def reverse(value: Int): Int = {
    var res: Long = 0
    var x = value
    while (x != 0) {
      res *= 10
      res += x % 10
      x /= 10
    }
    if (res > Int.MaxValue || res < Int.MinValue) 0 else res.toInt
  }

  // 如果不能用64bit
  def reverse2(value: Int): Int = {
    var res: Int = 0
    var x = value
    while (x != 0) {
      val pop = x % 10
      if (res > 214748364 || (res == 214748364 && pop > 7)) return 0
      if (res < -214748364 || (res == 214748364 && pop < -8)) return 0
      res = res * 10 + pop
      // continue
      x /= 10
    }
    res
  }
}