object L112 {

    private var sum = 0

    def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
        if (root == null) return false
        sum = 0
        dfs(root, targetSum)
    }

    private def dfs(root: TreeNode, target: Int): Boolean = {
        var res = false
        sum += root.value
        if (root.left == null && root.right == null && sum == target) {
            res = true
        } else if (root.left != null && dfs(root.left, target)) {
            res = true
        } else if (root.right != null && dfs(root.right, target)) {
            res = true
        } else {
            res = false
        }
        sum -= root.value
        res
    }
}