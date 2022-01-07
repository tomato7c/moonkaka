object L94 {
    def inorderTraversal(root: TreeNode): List[Int] = {
        val stack = collection.mutable.Stack[TreeNode]()
        val res = collection.mutable.ListBuffer[Int]()

        var cur = root
        while (stack.nonEmpty || cur != null) {
            if (cur != null) {
                stack.push(cur)
                cur = cur.left
            } else {
                cur = stack.pop
                res += cur.value
                cur = cur.right
            }
        }
        res.toList
    }
}