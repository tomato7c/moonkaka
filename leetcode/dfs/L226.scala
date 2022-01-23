object L226 {
    def invertTree(root: TreeNode): TreeNode = {
        if (root == null) return null
        val left = root.left
        root.left = invertTree(root.right)
        root.right = invertTree(left)
        root
    }
}