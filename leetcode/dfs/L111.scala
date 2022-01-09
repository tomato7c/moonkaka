object L111 {
    def minDepth(root: TreeNode): Int = {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1

        var res = Int.MaxValue
        if (root.left != null) res = Math.min(res, minDepth(root.left))
        if (root.right != null) res = Math.min(res, minDepth(root.right))

        res + 1
    }
}