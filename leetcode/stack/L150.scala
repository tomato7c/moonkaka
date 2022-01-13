object L150 {
    def evalRPN(tokens: Array[String]): Int = {
        val stack = collection.mutable.Stack[Int]()
        for (s <- tokens) {
            s match {
                case "+" => stack.push(stack.pop + stack.pop)
                case "-" => stack.push(-stack.pop + stack.pop)
                case "*" => stack.push(stack.pop * stack.pop)
                case "/" => {
                    val a = stack.pop
                    val b = stack.pop
                    stack.push(b / a)
                }
                case _ => stack.push(s.toInt)
            }
        }
        stack.pop
    }
}