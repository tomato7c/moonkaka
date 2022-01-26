import scala.util.control.Breaks.{break, breakable}
object Solution {
  def countValidWords(sentence: String): Int = {
    var res = 0
    val arr = sentence.split(" ")
    for (w <- arr if !w.equals(" ") && !w.isEmpty) {
      breakable(() -> {
        if (w.count(_ == '-') > 1) break
        if (w(0) == '-' || w.last == '-') break
        val index = w.indexOf('-')
        if (index > 0 && (!isLetter(w(index - 1)) || !isLetter(w(index + 1)))) break
        if (w.count(isNumber) > 0) break
        for (i <- w.indices) {
          val c = w(i)
          if (isPunc(c) && i != w.length - 1) break
        }
        res += 1
      })
    }
    res
  }

  private def isLetter(c: Char) = c >= 'a' && c <= 'z'

  private def isNumber(c: Char) = c >= '0' && c <= '9'

  private def isPunc(c: Char) = c == ',' || c == '.' || c == '!'
}