import scala.util.control.Breaks.{break, breakable}
// TODO 只写了暴力算法的实现，有时间再学习Kmp
object L28 {
  def strStr(haystack: String, needle: String): Int = {
    if (needle.isEmpty()) return 0
    for (i <- haystack.indices) {
      var a = i
      breakable {
        for (b <- needle.indices) {
            if (a < haystack.length && haystack(a) == needle(b)) {
                if (b == needle.length - 1) return i
                a += 1
            } else {
                break
            }
        }
      }
    }
    -1
  }
}