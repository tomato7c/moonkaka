object L85 {
    // 借助之前的柱状图最大面积...，每行可以用这个计算一次
    def maximalRectangle(matrix: Array[Array[Char]]): Int = {
        val m = matrix.length; val n = matrix(0).length
        val height = new Array[Int](n)
        var res = 0
        for (i <- 0 until m) {
            for (j <- 0 until n) {
                if (matrix(i)(j) == '1') height(j) += 1
                else height(j) = 0
            }
            res = Math.max(res, largestRectangleInHistogram(height))
        }
        res
    }

    private def largestRectangleInHistogram(height: Array[Int]): Int = {
        var res = 0
        val stack = collection.mutable.Stack[Int]()
        stack.push(-1)

        for (i <- height.indices) {
            while (stack.top != -1 && height(stack.top) > height(i)) {
                // 出栈，计算res
                val topIndex = stack.pop
                res = Math.max(res, height(topIndex) * (i - stack.top - 1))
            }
            stack.push(i)
        }
        while (stack.top != -1) {
            // 出栈，计算res
            val topIndex = stack.pop
            res = Math.max(res, height(topIndex) * (height.length - stack.top - 1))
        }
        res
    }
}