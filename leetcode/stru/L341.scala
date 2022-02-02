/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * trait NestedInteger {
 *
 *   // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *   def isInteger: Boolean
 *
 *   // Return the single integer that this NestedInteger holds, if it holds a single integer.
 *   def getInteger: Int
 *
 *   // Set this NestedInteger to hold a single integer.
 *   def setInteger(i: Int): Unit
 *
 *   // Return the nested list that this NestedInteger holds, if it holds a nested list.
 *   def getList: Array[NestedInteger]
 *
 *   // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *   def add(ni: NestedInteger): Unit
 * }
 */

// 所有元素逆序入栈(包括integer和nested)
// hasNext触发nested拍平
class NestedIterator(_nestedList: List[NestedInteger]) {

    val stack = collection.mutable.Stack[NestedInteger]()

    {
        stack.pushAll(_nestedList.reverse)
    }

    def next(): Int = {
        stack.pop.getInteger
    }
    
    def hasNext(): Boolean = {
        while (stack.nonEmpty) {
            if (stack.top.isInteger) return true
            stack.pushAll(stack.pop.getList.reverse)
        }
        false
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = new NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */