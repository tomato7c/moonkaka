// 数字reverse操作，不必关注溢出，溢出就是不相等
object L9 {

  def main(args: Array[String]): Unit = {
    assert(isPalindrome2(0))
    assert(!isPalindrome2(10))
    assert(!isPalindrome2(-10))
    assert(isPalindrome2(20202))
  }

  def isPalindrome1(x: Int): Boolean = {
    x.toString.equals(x.toString.reverse)
  }

  def isPalindrome2(x: Int): Boolean = {
    if (x < 0) return false
    reverse(x) == x
  }

  private def reverse(x1: Int): Int = {
    var res = 0
    var x = x1
    while (x != 0) {
      val pop = x % 10
      res = res * 10 + pop
      // continue
      x /= 10
    }
    res
  }
}
