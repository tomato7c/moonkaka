/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        if (root.value > p.value && root.value > q.value) {
            lowestCommonAncestor(root.left, p, q)
        } else if (root.value < p.value && root.value < q.value) {
            lowestCommonAncestor(root.right, p, q)
        } else {
            root
        }
    }
}
