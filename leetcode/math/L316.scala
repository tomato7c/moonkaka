object Solution {
    // 丢弃的标准为c出现的次数 > 1
    // 用单调栈维护字典序
    def removeDuplicateLetters(s: String): String = {
        val count = new Array[Int](256)
        for (c <- s) count(c) += 1

        val stack = collection.mutable.Stack[Char]()
        val inStack = new Array[Boolean](256)
        for (c <- s) {
            count(c) -= 1
            if (!inStack(c)) {
                while (stack.nonEmpty && count(stack.top) > 0 && stack.top > c) {
                    inStack(stack.pop) = false
                }
                stack.push(c)
                inStack(c) = true
            }
        }
        stack.reverse.mkString("")
    }
}