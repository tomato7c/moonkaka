object L113 {

    private var res: collection.mutable.ListBuffer[List[Int]] = null

    private var path: collection.mutable.Stack[Int] = null

    def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
        res = collection.mutable.ListBuffer[List[Int]]()
        path = collection.mutable.Stack[Int]()
        if (root == null) return res.toList
        dfs(root, targetSum)
        res.toList
    }

    private def dfs(root: TreeNode, remain: Int) {
        val v = root.value
        path.push(v)
        if (root.left == null && root.right == null && remain == v) res += path.toList.reverse
        if (root.left != null) dfs(root.left, remain - v)
        if (root.right != null) dfs(root.right, remain - v)
        path.pop
    }
}