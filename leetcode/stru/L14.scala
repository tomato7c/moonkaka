object L14 {

  def main(args: Array[String]): Unit = {
    assert(longestCommonPrefix(Array("flower","flow","flight")).equals("fl"))
    assert(longestCommonPrefix(Array("dog","racecar","car")).equals(""))
    assert(longestCommonPrefix(Array("")).equals(""))
    assert(longestCommonPrefix(Array("123", "")).equals(""))

    println('A'.toInt)
  }

  // 直接竖直扫描，m*n
  def longestCommonPrefix(strs: Array[String]): String = {
    assert(strs.length > 0)
    val common = strs(0)
    for (i <- common.indices) {
      for (s <- strs) {
        if (i >= s.length || s(i) != common(i)) return common.substring(0, i)
      }
    }
    common
  }
  // trie树 TODO
  def longestCommonPrefix2(strs: Array[String]): String = {

    ""
  }
}