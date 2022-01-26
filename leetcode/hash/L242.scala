object Solution {
  def isAnagram(s: String, t: String): Boolean = {
    val hash = new Array[Int](26)
    if (s.length != t.length) return false
    for (i <- s.indices) {
      hash(ofIndex(s(i))) += 1
      hash(ofIndex(t(i))) -= 1
    }

    !hash.exists(_ != 0)
  }

  private def ofIndex(c: Char): Int = c - 'a'
}