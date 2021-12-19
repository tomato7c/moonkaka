import scala.collection.mutable.{ArrayBuffer, ListBuffer}
object L29 {
    def divide(dividend: Int, divisor: Int): Int = {
        val isNegative = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0
        var x: Long = Math.abs(dividend.toLong)
        var y: Long = Math.abs(divisor.toLong)
        val exp = new ArrayBuffer[Long]()
        // 初始化二分数组exp: y, 2y, 4y...
        var i = y
        while (i <= x) {
            exp += i
            i += i
        }
        var res: Long = 0
        for (i <- exp.indices.reverse) {
            if (exp(i) <= x) {
                x -= exp(i)
                res += 1.toLong << i
            }
        }
        if (isNegative) res = -res
        if (res < Int.MinValue) return Int.MinValue
        if (res > Int.MaxValue) return Int.MaxValue

        res.toInt
    }
}