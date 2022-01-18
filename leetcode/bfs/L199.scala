object L199 {
    // bfs
    def rightSideView(root: TreeNode): List[Int] = {
        if (root == null) return List()
        val q = collection.mutable.Queue[TreeNode]()
        val res = collection.mutable.ListBuffer[Int]()
        q.enqueue(root)

        while (q.nonEmpty) {
            val size = q.size
            for (i <- 0 until size) {
                val cur = q.dequeue
                if (i == size - 1) res += cur.value
                if (cur.left != null) q.enqueue(cur.left)
                if (cur.right != null) q.enqueue(cur.right)
            }
        }
        res.toList
    }
}