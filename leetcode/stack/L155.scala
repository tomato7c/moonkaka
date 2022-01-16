class L155() {

    private val stack = collection.mutable.Stack[Int]()

    private val min = collection.mutable.Stack[Int]()

    def push(value: Int) {
        stack.push(value)
        if (min.isEmpty || min.top >= value) {
            min.push(value)
        }
    }

    def pop() {
        val pop = stack.pop
        if (min.top == pop) min.pop
    }

    def top(): Int = {
        stack.top
    }

    def getMin(): Int = {
        min.top
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */