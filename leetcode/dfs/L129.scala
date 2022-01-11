object L129 {

    private var res = 0
    // dfs
    def sumNumbers(root: TreeNode): Int = {
        if (root == null) return 0 
        res = 0
        dfs(root, 0)
        res
    }

    private def dfs(root: TreeNode, v: Int) {
        val sum = v * 10 + root.value
        if (root.left == null && root.right == null) {
            res += sum
            return
        }
        if (root.left != null) dfs(root.left, sum)
        if (root.right != null) dfs(root.right, sum)
    }
}