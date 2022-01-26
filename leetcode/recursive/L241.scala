object Solution {
    // 通过operator将左右两边拆分成两个子表达式递归处理，子表达式的值集合再应用到operator
    def diffWaysToCompute(expression: String): List[Int] = {
        val res = collection.mutable.ListBuffer[Int]()
        
        for (i <- expression.indices) {
            val c = expression(i)
            if (isOperator(c)) {
                val leftValues = diffWaysToCompute(expression.substring(0, i))
                val rightValues = diffWaysToCompute(expression.substring(i + 1))
                for (left <- leftValues; right <- rightValues) res += eval(c, left, right)
            }
        }
        if (res.size == 0) { // 表达式本身就是一个数值
            res += expression.toInt
        }

        res.toList
    }

    private def isOperator(c: Char): Boolean = c == '+' || c == '-' || c == '*'

    private def eval(operator: Char, left: Int, right: Int): Int = {
        operator match {
            case '+' => left + right
            case '-' => left - right
            case '*' => left * right
        }
    }
}