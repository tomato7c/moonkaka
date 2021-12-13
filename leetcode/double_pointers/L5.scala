
object L5 {

  def main(args: Array[String]): Unit = {
    assert(longestPalindrome("aacabdkacaa").equals("aca"))
    assert(longestPalindrome("a").equals("a"))
    assert(longestPalindrome("aa").equals("aa"))
  }

  // 简单的中心扩散，枚举两种不同的"中心"
  def longestPalindrome(s: String): String = {
    if (s.isEmpty) return s
    var max: Int = 0
    var res: String = s.substring(0, 1)
    for (i <- s.indices) {
      var a = i - 1
      var b = i + 1
      while (a >= 0 && b < s.length && s(a) == s(b)) {
        val length = b - a + 1
        if (length > max) {
          max = length
          res = s.substring(a, b + 1)
        }
        a -= 1
        b += 1
      }

      a = i - 1
      b = i
      while (a >= 0 && b < s.length && s(a) == s(b)) {
        val length = b - a + 1
        if ( b - a + 1 > max) {
          max = length
          res = s.substring(a, b + 1)
        }
        a -= 1
        b += 1
      }
    }
    res
  }
}