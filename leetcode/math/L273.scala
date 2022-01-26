object Solution {
  private val mapOne = Map(1 -> "One", 2 -> "Two", 3 -> "Three", 4 -> "Four", 5 -> "Five",
    6 -> "Six", 7 -> "Seven", 8 -> "Eight", 9 -> "Nine")

  private val mapTwo = Map(10 -> "Ten", 11 -> "Eleven", 12 -> "Twelve", 13 -> "Thirteen", 14 -> "Fourteen", 15 -> "Fifteen",
    16 -> "Sixteen", 17 -> "Seventeen", 18 -> "Eighteen", 19 -> "Nineteen", 20 -> "Twenty")

  private val mapThree = Map(2 -> "Twenty", 3 -> "Thirty", 4 -> "Forty", 5 -> "Fifty",
    6 -> "Sixty", 7 -> "Seventy", 8 -> "Eighty", 9 -> "Ninety")

  def numberToWords(num: Int): String = {
    if (num == 0) return "Zero"
    var remain = num
    val res = new StringBuilder()
    var count = remain / 1000_000_000
    remain %= 1000_000_000
    if (count != 0) {
      res.append(sayThree(count)).append("Billion").append(" ")
    }
    count = remain / 1000_000
    remain %= 1000_000
    if (count != 0) {
      res.append(sayThree(count)).append("Million").append(" ")
    }
    count = remain / 1000
    remain %= 1000
    if (count != 0) {
      res.append(sayThree(count)).append("Thousand").append(" ")
    }
    count = remain
    if (count != 0) {
      res.append(sayThree(count))
    }
    // 10 + , 20 + , 30 + , 40 + ...
    res.toString.trim
  }

  private def sayThree(n: Int): String = {
    val res = new StringBuilder()
    var remain = n
    var count = remain / 100
    remain %= 100
    if (count != 0) {
      res.append(mapOne(count)).append(" ").append("Hundred").append(" ")
    }
    if (remain > 20) {
      count = remain / 10
      remain %= 10
      if (count != 0) res.append(mapThree(count)).append(" ")
      count = remain
      if (count != 0) res.append(mapOne(count)).append(" ")
    } else if (remain >= 10) {
      res.append(mapTwo(remain)).append(" ")
    } else if (remain > 0) {
      res.append(mapOne(remain)).append(" ")
    }
    res.toString()
  }
}