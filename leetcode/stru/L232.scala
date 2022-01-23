class MyQueue() {

    private val stackA = collection.mutable.Stack[Int]()

    private val stackB = collection.mutable.Stack[Int]()

    def push(x: Int) {
        stackA.push(x)
    }

    def pop(): Int = {
        if (stackB.isEmpty) {
            while (stackA.nonEmpty) stackB.push(stackA.pop)
        }
        stackB.pop
    }

    def peek(): Int = {
        if (stackB.isEmpty) {
            while (stackA.nonEmpty) stackB.push(stackA.pop)
        }
        stackB.top
    }

    def empty(): Boolean = {
        stackA.isEmpty && stackB.isEmpty
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */