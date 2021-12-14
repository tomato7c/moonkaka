// map, 贪心
object L12 {

  private val map = Map[Int, String](0 -> "",
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V",
    6 -> "VI", 7 -> "VII", 8 -> "VIII", 9 -> "IX",
    10 -> "X", 20 -> "XX", 30 -> "XXX", 40 -> "XL", 50 -> "L",
    60 -> "LX", 70 -> "LXX", 80 -> "LXXX", 90 -> "XC",
    100 -> "C", 200 -> "CC", 300 -> "CCC", 400 -> "CD", 500 -> "D",
    600 -> "DC", 700 -> "DCC", 800 -> "DCCC", 900 -> "CM",
    1000 -> "M", 2000 -> "MM", 3000 -> "MMM"
  )

  def main(args: Array[String]): Unit = {
    assert(intToRoman2(3).equals("III"))
    assert(intToRoman2(4).equals("IV"))
    assert(intToRoman2(58).equals("LVIII"))
    assert(intToRoman2(1994).equals("MCMXCIV"))
    assert(intToRoman2(3999).equals("MMMCMXCIX"))
  }

  /**
   * 1. 依然是枚举每一位
   * 2. 本题的特殊点是从高位开始,可以通过先乘再除的方式将数字"向下取整"
   */
  def intToRoman1(num1: Int): String = {
    var num = num1
    var a = 1000
    val res = new StringBuilder
    while (a != 0) {
      val key = (num / a) * a
      res.append(map(key))
      // continue
      num %= a
      a /= 10
    }
    res.toString
  }

  // 维护所有"币种"的映射，从高位开始迭代，用while实现"I" -> "III"
  def intToRoman2(x1: Int): String = {
    val map = Map[Int, String](
      1000 -> "M", 900 -> "CM", 500 -> "D", 400 -> "CD", 100 -> "C",
      90 -> "XC", 50 -> "L", 40 -> "XL", 10 -> "X",
      9 -> "IX", 5 -> "V", 4 -> "IV", 1 -> "I")
    val arr = Array(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    var x = x1
    val res = new StringBuilder
    arr.foreach(key => {
      while (x >= key) {
        res.append(map(key))
        x -= key
      }
    })
    res.toString
  }
}
