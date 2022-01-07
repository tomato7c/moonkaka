object L103 {
    def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
        val res = collection.mutable.ListBuffer[List[Int]]()
        if (root == null) return res.toList
        var order = true
        val q = collection.mutable.Queue[TreeNode]()
        val level = collection.mutable.ListBuffer[Int]()
        var currLevel = 1; var nextLevel = 0
        q.enqueue(root)
        while (q.nonEmpty) {
            val cur = q.dequeue
            level += cur.value
            currLevel -= 1

            if (cur.left != null) {
                q.enqueue(cur.left)
                nextLevel += 1
            }
            if (cur.right != null) {
                q.enqueue(cur.right)
                nextLevel += 1
            }

            if (currLevel == 0) {
                if (order) {
                    res += level.toList
                } else {
                    res += level.reverse.toList
                }
                order = !order
                currLevel = nextLevel
                nextLevel = 0
                level.clear
            }
        }
        res.toList
    }
}