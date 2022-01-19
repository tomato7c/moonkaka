object L207 {
    // 拓扑排序后无环
    // 1.统计所有节点入度，后继节点 2.入度为0时入队列 3.出队表示上文这门课程，更新所有后继节点入度 4.最后判断修过的课程和总数是否相等
    def canFinish(n: Int, edges: Array[Array[Int]]): Boolean = {
        // 统计所有点入度
        val inDeg = new Array[Int](n)
        val postClass = new Array[collection.mutable.ListBuffer[Int]](n)
        for (i <- 0 until n) postClass(i) = collection.mutable.ListBuffer[Int]()
        for (e <- edges) {
            // e(0)后继 e(1)前驱
            inDeg(e(0)) += 1 // 入度 + 1
            postClass(e(1)) += e(0)
        }
        val q = collection.mutable.Queue[Int]()
        for (i <- inDeg.indices if inDeg(i) == 0) q.enqueue(i)
        var count = 0 // 学习的课程数
        while (q.nonEmpty) {
            count += 1
            var cur = q.dequeue
            var postList = postClass(cur)
            for (i <- postList.indices) {
                val classNo = postList(i)
                inDeg(classNo) -= 1
                if (inDeg(classNo) == 0) q.enqueue(classNo)
            }
        }
        count == n
    }
}