import scala.util.control.Breaks.{break, breakable}
object Solution {
    // 合法括号序列的性质 1. 左右括号数量相同 2. 任一前缀，左括号数量 >= 右括号数量
    // 为什么bfs能找到答案？ level表示remove的数量，当出现答案时，直接短路掉下一层级的搜索，本层级就是最小remove次数的所有答案区间
    def removeInvalidParentheses(s: String): List[String] = {
        val q = collection.mutable.Queue[String]()
        val res = collection.mutable.ListBuffer[String]()
        val visited = collection.mutable.Set[String]()
        var found = false
        // initialize
        q.enqueue(s)
        visited += s

        while (q.nonEmpty) {
            val size = q.size
            for (temp <- 0 until size) { // enumerate a level
                val state = q.dequeue
                breakable({
                    if (isValid(state)) {
                        res += state
                        found = true
                    }
                    if (found) break
                    // 枚举移除位置
                    for (i <- 0 until state.length) {
                        if (state(i) == '(' || state(i) == ')') { // can remove
                            val newState = state.substring(0, i) + state.substring(i + 1)
                            if (!visited.contains(newState)) {
                                visited += newState
                                q.enqueue(newState)
                            }
                        }
                    }
                })
            }
        }
        res.toList
    }

    private def isValid(s: String): Boolean = {
        var score = 0
        for (c <- s) {
            if (c == '(') score += 1
            if (c == ')') score -= 1
            if (score < 0) return false
        }
        score == 0
    }
}