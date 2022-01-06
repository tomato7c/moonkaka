object L100 {
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
        dfs(p, q)
    }

    private def dfs(a: TreeNode, b: TreeNode): Boolean = {
        if (a == null && b == null) return true
        if (a == null && b != null || a != null && b == null) return false
        if (a.value != b.value) return false

        dfs(a.left, b.left) && dfs(a.right, b.right)
    }
}