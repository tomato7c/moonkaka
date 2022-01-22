/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object L222 {
    // 完全二叉树由多个"满二叉树"组成，可以通过层数快速算出满二叉树的节点数量
    def countNodes(root: TreeNode): Int = {
        if (root == null) return 0
        var left = root.left; var right = root.right
        var leftLevel = 1; var rightLevel = 1
        while (left != null) {
            left = left.left
            leftLevel += 1
        }
        while (right != null) {
            right = right.right
            rightLevel += 1
        }
        if (leftLevel == rightLevel) return (1 << leftLevel) - 1

        countNodes(root.left) + 1 + countNodes(root.right)
    }
}