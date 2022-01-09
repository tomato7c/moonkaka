object L110 {
    def isBalanced(root: TreeNode): Boolean = {
        if (root == null) return true

        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right)
    }

    private def maxDepth(root: TreeNode): Int = {
        if (root == null) return 0

        if (root.left == null && root.right == null) return 1

        Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}