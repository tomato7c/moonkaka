object L3 {

  def main(args: Array[String]): Unit = {
    val a = 'b' - 'a'
    assert(lengthOfLongestSubstring("") == 0)
    assert(lengthOfLongestSubstring("bbb") == 1)
    assert(lengthOfLongestSubstring("abcdwagd") == 6)
  }

  // 双指针，维护最大长度sum; 更hack的方式，用map保存index映射，直接计算两个指针间距离
  def lengthOfLongestSubstring(s: String): Int = {
    if (s == null) return 0
    val set = collection.mutable.Set[Char]()
    var max, a, b = 0
    while (b < s.length) {
      if (set.contains(s.charAt(b))) {
        set -= s(a)
        a += 1
      } else {
        set += s(b)
        max = Math.max(max, set.size)
        b += 1
      }
    }
    max
  }
}