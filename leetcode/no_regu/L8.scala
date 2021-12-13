// 数字计算操作，解耦数据溢出
object L8 {
	def main(args: Array[String]): Unit = {
  assert(myAtoi("-0014") == -14)
  assert(myAtoi("2147483647") == 2147483647)
  assert(myAtoi("   -2147483648") == -2147483648)
  assert(myAtoi("a 123") == 0)
  assert(myAtoi("1.d") == 1)
}
/**
 * 1. 无效空格直接用trim
 * 2. 中间状态用正数存储时，遇到溢出直接返回最值
 * 3. 不必关注溢出，可以提前避免
 */
def myAtoi(s1: String): Int = {
  val s = s1.trim
  var isPositive = true
  var i, res = 0
  if (i < s.length && (s(i) == '+' || s(i) == '-')) {
    if (s(i) == '-') isPositive = false
    i += 1
  }
  while (i < s.length && isNumber(s(i))) {
    val add = s(i) - '0'
    if (isPositive && (res > Int.MaxValue/10 || (res == Int.MaxValue/10 && add >= 7))) return Int.MaxValue
    if (!isPositive && (res > Int.MaxValue/10 || (res == Int.MaxValue/10 && add > 8))) return Int.MinValue

    res = res * 10 + add
    i += 1
  }

  if (!isPositive) res *= -1
  	res
  }

  private def isNumber(c: Char): Boolean = c >= '0' && c <= '9'
}