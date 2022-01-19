object L210 {
  // 类比Course Schedule I, 1. 统计入度，后继列表 2. 入度0的节点(无先行课程) 入队列 3. 出队列，学习该课程 4. 维护课程后继节点入度
  def findOrder(n: Int, edges: Array[Array[Int]]): Array[Int] = {
    val res = collection.mutable.ListBuffer[Int]()
    val inDegree = new Array[Int](n)
    val postClassList = new Array[collection.mutable.ListBuffer[Int]](n)
    for (i <- postClassList.indices) postClassList(i) = collection.mutable.ListBuffer[Int]()
    for (e <- edges) {
      val pre = e(1); val post = e(0)
      inDegree(post) += 1
      postClassList(pre) += post // 为先行课程添加后继节点列表
    }
    val q = collection.mutable.Queue[Int]()
    for (i <- inDegree.indices if inDegree(i) == 0) q.enqueue(i) 
    while (q.nonEmpty) {
      val cur = q.dequeue
      res += cur
      for (classNo <- postClassList(cur)) {
        inDegree(classNo) -= 1
        if (inDegree(classNo) == 0) q.enqueue(classNo)
      }
    }
    
    if (res.size == n) res.toArray else Array[Int]()
  }
}