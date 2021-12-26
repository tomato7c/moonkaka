object L38 {

  def main(args: Array[String]): Unit = {
    assert(countAndSay(1).equals("1"))
    assert(countAndSay(2).equals("11"))
    assert(countAndSay(3).equals("21"))
    assert(countAndSay(4).equals("1211"))
  }
  // 普通迭代 + 双指针
  def countAndSay(n: Int): String = {
    var res = "1"
    for (temp <- 1 until n) {
      val s = new StringBuilder
      var i = 0
      while (i < res.length) {
        var j = i + 1
        while (j < res.length && res(j) == res(i)) j += 1
        s.append(j - i).append(res(i))
        i = j
      }
      res = s.toString()
    }
    res
  }
}