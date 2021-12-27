object L42 {

  def main(args: Array[String]): Unit = {
    assert(trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) == 6)
    assert(trap(Array(1, 1, 1, 1, 1)) == 0)
    assert(trap(Array(1, 3, 4, 4, 1, 1)) == 0)
  }
  // 模拟，单调栈维护index，遇到>=栈顶元素, pop并计算面积
  def trap(height: Array[Int]): Int = {
    val stack = collection.mutable.Stack[Int]()
    var res = 0
    for (index <- height.indices) {
      while (stack.nonEmpty && height(stack.top) <= height(index)) {
        val lowIndex = stack.pop()
        if (stack.nonEmpty) {
          val h = Math.min(height(index), height(stack.top)) - height(lowIndex)
          val w = index - stack.top - 1
          res += w * h
        }
      }
      stack.push(index)
    }
    res
  }
}