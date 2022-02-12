object Solution {
    def decodeString(s: String): String = {
        val stack = collection.mutable.Stack[String]()
        def popNumber(): Int = {
            var res = new StringBuilder
            while (stack.nonEmpty && stack.top.head.isDigit) {
                res += stack.pop()(0)
            }
            res.reverse.toString.toInt
        }
        def popString(): String = {
            val res = collection.mutable.ListBuffer[String]()
            while (stack.top != "[") res += stack.pop
            stack.pop // pop "["
            res.reverse.mkString
        }

        for (c <- s) {
            if (c == ']') {
                stack.push(popString() * popNumber())
            } else {
                stack.push(c.toString)
            }
        }
        stack.reverse.mkString
    }
}