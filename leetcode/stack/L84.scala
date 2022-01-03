object L84 {
    // 2  1  2
    // 遇到与栈顶元素非递增时，以栈顶元素为高的矩形面积是确定的，保证栈单调性
    def largestRectangleArea(heights: Array[Int]): Int = {
        val stack = collection.mutable.Stack[Int]()
        stack.push(-1)
        var res = -1
        for (i <- heights.indices) {
            while (stack.top != -1 && heights(stack.top) > heights(i)) {
                val topIndex = stack.pop
                res = Math.max(res, heights(topIndex) * (i - stack.top - 1))
            }
            stack.push(i)
        }
        while (stack.top != -1) {
            val topIndex = stack.pop
            res = Math.max(res, heights(topIndex) * (heights.length - stack.top - 1))
        }
    res
    }
}