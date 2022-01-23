object L227 {
    // 栈中存放每一个可以求和的 “表达式值”, 遇到* /更新栈顶元素
    def calculate(_s: String): Int = {
        val s = _s.replace(" ", "")
        val stack = collection.mutable.Stack[Int]()
        var sign = '+'
        var value = 0
        for (i <- s.indices) {
            val c = s(i)
            if (c.isDigit) {
                value = value * 10 + (c - '0')
            }
            if (!c.isDigit || i == s.length - 1) {
                sign match {
                    case '+' => stack.push(value)
                    case '-' => stack.push(-value)
                    case '*' => stack.push(stack.pop * value)
                    case '/' => stack.push(stack.pop / value)
                    case _ =>
                }
                sign = c
                value = 0
            }
        }
        stack.sum
    }
}