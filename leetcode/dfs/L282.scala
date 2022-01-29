import scala.util.control.Breaks.{break, breakable}
import scala.collection.mutable.ListBuffer
object Solution {

    private var res: ListBuffer[String] = null
    private var s: String = null
    private var target: Int = -1

    def addOperators(num: String, _target: Int): List[String] = {
        res = ListBuffer[String]()
        s = num
        target = _target
        dfs(0, 0, 0, "")

        res.toList
    }

    // preUnitValue表示上一次表达式单元的操作值，如 1-2，preUnitValue为-2
    private def dfs(start: Int, preUnitValue: Long, cur: Long, expression: String) {
        if (start == s.length) {
            if (cur == target) res += expression
            return
        }
        // 枚举4个符号放到哪个位置
        for (i <- start until s.length) {
            breakable({
                // 0只能作为单独值，而不是前缀
                if (s(start) == '0' && i != start) break
                val next = s.substring(start, i + 1).toLong
                // 只有start为0时必须拼接空白符号
                if (start == 0) {
                    dfs(i + 1, next, next, next.toString)
                } else {
                    dfs(i + 1, next, cur + next, expression + "+" + next)
                    dfs(i + 1, -next, cur - next, expression + "-" + next)
                    val unit = preUnitValue * next
                    dfs(i + 1, unit, cur - preUnitValue + unit, expression + "*" + next)
                 }
            })
        }
    }
}