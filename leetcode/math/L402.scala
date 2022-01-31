object Solution {
    // 一种贪心策略，当前树不能比前一个数小，如果小的话，就要用当前数替换前一位数，同时记移除一次
    // 注意k需要补偿减到0, 以及去掉前缀0
    def removeKdigits(arr: String, _k: Int): String = {
        var k = _k
        var stack = collection.mutable.Stack[Char]()

        for (v <- arr) {
            while (stack.nonEmpty && k > 0 && stack.top > v) {
                stack.pop
                k -= 1
            }
            stack.push(v)
        }
        
        while (k > 0) {
            stack.pop
            k -= 1
        }
        // reverse来去掉前缀0
        stack = stack.reverse
        while (stack.nonEmpty && stack.top == '0') stack.pop
        val res = new StringBuilder()
        res.appendAll(stack)
        if (res.isEmpty) "0" else res.toString
    }
}