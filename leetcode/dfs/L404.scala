/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def sumOfLeftLeaves(root: TreeNode): Int = {
        if (root == null) return 0
        dfs(root, false)
    }

    // 计算root的左叶子之和
    private def dfs(root: TreeNode, isLeft: Boolean): Int = {
        var res = 0
        if (root.left == null && root.right == null && isLeft) res += root.value
        if (root.left != null) res += dfs(root.left, true)
        if (root.right != null) res += dfs(root.right, false)
        res
    }
}