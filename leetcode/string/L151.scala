object L151 {
    def reverseWords_v1(s: String): String = {
        s.split(" ").filter(it => !it.trim.isEmpty).reverse.mkString(" ")
    }

  def reverseWords_v2(s: String): String = {
    val sb = new StringBuilder
    var i = 0
    breakable({
      while (i < s.length) {
        while (i < s.length && s(i) == ' ') i += 1
        var j = i
        if (j == s.length) break
        while (j < s.length && s(j) != ' ') j += 1
        for (k <- (i until j).reverse) sb.addOne(s(k))
        sb.addOne(' ')
        i = j
      }
    })
    if (sb.size > 1 && sb.last == ' ') sb.deleteCharAt(sb.size - 1)
    sb.reverse.toString()
  }
}