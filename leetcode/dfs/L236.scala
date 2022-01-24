/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    // root 是p或q, 则root为结果
    // root左边有p，q之一，root右边有p,q之一，则root为结果
    // root左边找到a为p，q之一, a为结果； root右边找到b为p,q之一，b为结果
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        if (root == null || root == p || root == q) return root
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        if (left != null && right != null) return root
        if (left != null) left else right
    }
}