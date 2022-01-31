object Solution {
    // count维护次数，inStack维护是否在栈中， 单调栈实现字典序
    def smallestSubsequence(s: String): String = {
        val stack = collection.mutable.Stack[Char]()
        val inStack = new Array[Boolean](256)
        val count = new Array[Int](256)

        for (c <- s) count(c) += 1
        for (c <- s) {
            count(c) -= 1
            if (!inStack(c)) {
                while (stack.nonEmpty && stack.top > c && count(stack.top) > 0) {
                    inStack(stack.pop) = false
                }
                stack.push(c)
                inStack(c) = true
            }
        }
        stack.reverse.mkString("")
    }
}