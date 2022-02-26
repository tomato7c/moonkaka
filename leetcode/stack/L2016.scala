object Solution {
    // 单调栈
    def maximumDifference(arr: Array[Int]): Int = {
        var maxDiff = -1
        val stack = collection.mutable.Stack[Int]()
        stack.push(arr.head)
        var minVal = arr.head
        for (i <- 1 until arr.length) {
            val v = arr(i)
            while (stack.nonEmpty && stack.top >= v) stack.pop
            if (stack.isEmpty) {
                minVal = v
                stack.push(v)
            } else {
                stack.push(v)
                maxDiff = maxDiff.max(stack.top - minVal)
            }
        }
        maxDiff
    }
}