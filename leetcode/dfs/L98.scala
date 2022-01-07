object L98 {

    var pre: Long = -1L

    def isValidBST(root: TreeNode): Boolean = {
        pre = Long.MinValue
        dfs(root)
    }

    private def dfs(root: TreeNode): Boolean = {
        if (root == null) return true
        var valid = dfs(root.left)
        if (!valid) return false
        if (root.value <= pre) {
            return false
        } else {
            pre = root.value
        }
        dfs(root.right)
    }
}