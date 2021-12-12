object L6 {

  def main(args: Array[String]): Unit = {
    assert(convert("a", 1).equals("a"))
    assert(convert("1234", 2).equals("1324"))
    assert(convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"))
    assert(convert("PAYPALISHIRING", 1).equals("PAYPALISHIRING"))
  }

  /**
   * 1. "电梯式"顺序枚举数字(0,1,2,1,0,1,2,1,0...), 通过 + 正负值实现这些数字的枚举；不同z字形顺序可通过逆转builder顺序，逆转builder字符串顺序
   * 2. 直接找数学规律也行
   * 3. TODO真正的z字形顺序暂时没想到好的模拟方法
   */
  def convert(s: String, numRows: Int): String = {
    if (numRows < 2) return s
    val arr = new Array[StringBuilder](numRows)
    for (i <- arr.indices) arr(i) = new StringBuilder

    var plus = -1
    var i = 0
    for (c <- s) {
      if (i == 0 || i == numRows - 1) plus = -plus
      arr(i) += c
      i += plus
    }

    var res = ""
    for (s <- arr) res += s
    res
  }
}