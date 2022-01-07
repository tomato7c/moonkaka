object L107 {
    // 翻转一下...
    def levelOrderBottom(root: TreeNode): List[List[Int]] = {
        val res = collection.mutable.ListBuffer[List[Int]]()
        if (root == null) return res.toList
        val queue = collection.mutable.Queue[TreeNode]()
        val path = collection.mutable.ListBuffer[Int]()

        queue.enqueue(root)
        var nextLevel = 0
        var currentLevel = 1
        while (queue.nonEmpty) {
            val cur = queue.dequeue()
            path += cur.value
            currentLevel -= 1
            if (cur.left != null) {
                queue.enqueue(cur.left)
                nextLevel += 1
            }
            if (cur.right != null) {
                queue.enqueue(cur.right)
                nextLevel += 1
            }
            if (currentLevel == 0) {
                res += path.toList
                path.clear()
                currentLevel = nextLevel
                nextLevel = 0
            }
        }
        res.reverse.toList
    }
}