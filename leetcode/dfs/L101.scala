/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object L101 {
    def isSymmetric(root: TreeNode): Boolean = {
        if (root == null) return true

        dfs(root.left, root.right)
    }

    private def dfs(a: TreeNode, b: TreeNode): Boolean = {
        if (a == null && b == null) return true
        if (a == null || b == null) return false
        if (a.value != b.value) return false

        return dfs(a.left, b.right) && dfs(a.right, b.left)
    }
}
