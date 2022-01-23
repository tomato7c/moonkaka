object L224 {
    // 每个数抽象成op.apply(num), 遇到(保存状态，遇到)恢复状态
    def calculate(s: String): Int = {
        val stack = collection.mutable.Stack[Int]()
        var res = 0
        var num = 0; var sign = 1 // default '+'
        for (c <- s) {
            if (c.isDigit) {
                num = num * 10 + (c - '0')
            } else if (c == '+') {
                res += sign * num
                sign = 1; num = 0
            } else if (c == '-') {
                res += sign * num
                sign = -1; num = 0
            } else if (c == '(') {
                stack.push(res) // store res before this parathesis expression
                stack.push(sign) // store the sign of this parathesis expression
                res = 0; sign = 1
            } else if (c == ')') {
                res += sign * num
                num = 0
                res *= stack.pop // value of parathesis expression
                res += stack.pop
            }
        }
        res += sign * num
        res
    }
}