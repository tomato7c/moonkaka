import scala.util.control.Breaks.{break, breakable}
object L306 {
    // dfs, 确定好前两个数后，可以dfs剩余数的集合
    def isAdditiveNumber(s: String): Boolean = {
        if (s.length < 3) return false
        for (i <- 1 until s.length ) {
            if (s(0) == '0' && i > 1) return false // 第一个数以0开头，只能是0
            for (j <- i + 1 until s.length) {
                breakable({
                    if (s(i) == '0' && j != i + 1) break // 第一个数是s(i)
                    val a = s.substring(0, i).toLong
                    val b = s.substring(i, j).toLong
                    if (dfs(s.substring(j), a, b)) return true
                })
            }
        }
        return false
    }

    private def dfs(s: String, a: Long, b: Long): Boolean = {
        if (s.isEmpty()) return true
        for (i <- 1 to s.length) {
            if (s(0) == '0' && i > 1) return false // 如果第一位是0，则第一个数只能是0 => i不可能大于1
            val c = s.substring(0, i).toLong
            if (a + b == c) {
                return dfs(s.substring(i), b, c)
            } else if (a + b < c) {
                return false
            }
        }
        return false
    }
}