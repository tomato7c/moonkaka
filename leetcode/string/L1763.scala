object Solution {
  def longestNiceSubstring(s: String): String = {
    var res = ""
    for (i <- s.indices) {
      for (j <- i + 1 to s.length if j - i > res.length) {
        val sub = s.substring(i, j)
        if (isNiceString(sub)) res = sub
      }
    }
    res
  }

  private def isNiceString(s: String): Boolean = {
    val set = Set.from(s)
    for (c <- s) {
      val a = c.toLower; val b = c.toUpper
      if (!set.contains(a) || !set.contains(b)) return false
    }
    true
  }
}