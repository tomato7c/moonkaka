object L20 {
    def isValid(s: String): Boolean = {
        val stack = new collection.mutable.Stack[Char]()
        for (c <- s) {
            if (isOpen(c)) {
                stack.push(c)
            } else {
                if (!stack.isEmpty && stack.top == toOpen(c)) {
                    stack.pop
                } else {
                    return false
                }
            }
        }
        return stack.isEmpty
    }

    private def isOpen(c: Char): Boolean  = c == '(' || c == '[' || c == '{'

    private def isClose(c: Char): Boolean = !isOpen(c)

    private def toOpen(c: Char): Char = c match {
        case ')' => '('
        case ']' => '['
        case '}' => '{'
    }
}