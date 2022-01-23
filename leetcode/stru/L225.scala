// 沙雕操作，pop时，先将前N-1个挪出去，pop操作完后再挪回来
class MyStack() {

    private val q = collection.mutable.Queue[Int]()

    private val temp = collection.mutable.Queue[Int]()

    def push(x: Int) {
        q.enqueue(x)
    }

    def pop(): Int = {
        val size = q.size
        for (i <- 0 until size - 1) temp.enqueue(q.dequeue)
        val res = q.dequeue
        while (temp.nonEmpty) q.enqueue(temp.dequeue)
        res
    }

    def top(): Int = {
        val size = q.size
        for (i <- 0 until size - 1) temp.enqueue(q.dequeue)
        val res = q.dequeue
        temp.enqueue(res)
        while (temp.nonEmpty) q.enqueue(temp.dequeue)
        res
    }

    def empty(): Boolean = {
        q.isEmpty
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */