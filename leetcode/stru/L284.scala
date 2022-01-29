// Scala Iterator reference:
// https://www.scala-lang.org/api/2.12.2/scala/collection/Iterator.html
// 超前读一位
class PeekingIterator(_iterator: Iterator[Int]) {

    private var cur: Int = -1
    private var exist: Boolean = false

    {
        exist = _iterator.hasNext
        if (exist) cur = _iterator.next
    }

    def peek(): Int = {
        cur
    }
    
    def next(): Int = {
        val res = cur
        exist = _iterator.hasNext
        if (exist) cur = _iterator.next

        res
    }
    
    def hasNext(): Boolean = {
        exist
    }
}

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = new PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */