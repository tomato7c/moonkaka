object L13 {

  def main(args: Array[String]): Unit = {
    assert(romanToInt("MMMCMXCIX") == 3999)
    assert(romanToInt("MCMXCIV") == 1994)
    assert(romanToInt("LVIII") == 58)
    assert(romanToInt("IV") == 4)
    assert(romanToInt("III") == 3)

  }

  // 同intToRoman, 只需向后取1或2位判断"币种", 优先判断2位
  def romanToInt(s: String): Int = {
    val map = Map[String, Int](
      "M" -> 1000, "CM" -> 900, "D" -> 500, "CD" -> 400,
      "C" -> 100, "XC" -> 90, "L" -> 50, "XL" -> 40,
      "X" -> 10, "IX" -> 9, "V" -> 5, "IV" -> 4, "I" -> 1)
    var index, res = 0
    while (index < s.length) {
      if (index + 2 <= s.length && map.contains(s.substring(index, index + 2))) {
        res += map(s.substring(index, index + 2))
        index += 2
      } else {
        res += map(s.substring(index, index + 1))
        index += 1
      }
    }
    res
  }
}