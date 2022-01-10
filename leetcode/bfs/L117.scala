object L117 {
    // 借助队列实现bfs
    def connect_v1(root: Node): Node = {
        if (root == null) return root
        val q = collection.mutable.Queue[Node]()
        q.enqueue(root)
        while (q.nonEmpty) {
            var pre: Node = null
            for (temp <- 0 until q.size) {
                val cur = q.dequeue
                if (pre == null) {
                    pre = cur
                } else {
                    pre.next = cur
                    pre = cur
                }
                if (cur.left != null) q.enqueue(cur.left)
                if (cur.right != null) q.enqueue(cur.right)
            }
        }
        root
    }

    def connect_v2(root: Node): Node = {
        if (root == null) return null
        var cur = root
        while (cur != null) {
            var pre, down: Node = null
            while (cur != null) {
                breakable({
                    if (cur.left == null && cur.right == null) {
                        cur = cur.next
                        break
                    }
                    // 连接左右
                    if (cur.left != null) cur.left.next = cur.right
                    // connect pre and cur
                    if (pre != null) pre.next = firstNonNull(cur.left, cur.right)
                    pre = firstNonNull(cur.right, cur.left)
                    if (down == null) down = firstNonNull(cur.left, cur.right)
                    cur = cur.next
                })
            }
            cur = down
        }
        root
    }

    private def firstNonNull(a: Node, b: Node): Node = if (a != null) a else b
}