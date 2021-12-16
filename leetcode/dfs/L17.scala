object L17 {

  private val map = Map[Char, String]('2' -> "abc", '3' -> "def", '4' -> "ghi",
    '5' -> "jkl", '6' -> "mno", '7' -> "pqrs", '8' -> "tuv", '9' -> "wxyz")

  private val res = collection.mutable.ListBuffer[String]()

  def main(args: Array[String]): Unit = {
    println(letterCombinations("23"))
    res.clear()
    println(letterCombinations(""))
    res.clear()
    println(letterCombinations("9"))
    res.clear()
    println(letterCombinations("555"))
  }
  // dfs  TODO 可以看leetcode上的def内def
  def letterCombinations(digits: String): List[String] = {
    if (digits.isEmpty) return res.toList

    dfs("", digits)
    res.toList
  }

  private def dfs(conbination: String, remainDigits: String): Unit = {
    if (remainDigits.length == 0) {
      res.addOne(conbination)
      return
    }
    for (c <- map(remainDigits(0))) {
      dfs(conbination + c, remainDigits.substring(1))
    }
  }
}