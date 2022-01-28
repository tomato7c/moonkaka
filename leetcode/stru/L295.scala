class MedianFinder() {

    val maxHeap = collection.mutable.PriorityQueue[Int]()

    val minHeap = collection.mutable.PriorityQueue[Int]().reverse

    // 维护minHeap, maxHeap
    // 先放max堆，再移到min堆，再调整size
    def addNum(num: Int) {
        maxHeap.enqueue(num)
        minHeap.enqueue(maxHeap.dequeue)
        if (minHeap.size > maxHeap.size) maxHeap.enqueue(minHeap.dequeue)
    }

    def findMedian(): Double = {
        if (maxHeap.size > minHeap.size) maxHeap.head
        else (maxHeap.head + minHeap.head) / 2.0
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = new MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */