object L114 {

    private var pre: TreeNode = null

    def flatten(root: TreeNode): Unit = {
        pre = new TreeNode
        dfs(root)
        pre.right
    }

    private def dfs(root: TreeNode) {
        if (root == null) return
        pre.right = root
        pre.left = null
        pre = root
        val right = root.right // 右节点可能会被篡改
        dfs(root.left)
        dfs(right)
    }
}