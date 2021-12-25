object L32 {

  def main(args: Array[String]): Unit = {
    assert(longestValidParentheses("(()") == 2)
    assert(longestValidParentheses(")()())") == 4)
    assert(longestValidParentheses("((") == 0)
    assert(longestValidParentheses("()") == 2)
  }

  /**
   * 合法的左右括号满足两个条件1.左右括号数量相等; 2.任一位置右括号数量<=左括号数
   * 分治的思想，整个序列可以拆成多个独立的小序列，只要能找出一个点，合法的括号序列不会跨越这个点，就可将不同的小序列独立处理
   * 每段除最后一个位置外，均满足<=条件，即任何一个close,一定能找到一个对应的open
   */
  def longestValidParentheses(s: String): Int = {
    var res = 0
    var start = -1
    val stack = collection.mutable.Stack[Int]()
    for (i <- s.indices) {
      if (s(i) == '(') {
        stack.push(i)
      } else {
        if (stack.nonEmpty) {
          stack.pop
          if (stack.nonEmpty) {
            res = Math.max(res, i - stack.top)
          } else {
            res = Math.max(res, i - start)
          }
        } else {
          start = i
        }
      }
    }
    res
  }
}