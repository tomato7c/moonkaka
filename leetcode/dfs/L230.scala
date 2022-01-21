/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object L230 {
    def kthSmallest(root: TreeNode, k: Int): Int = {
        val stack = collection.mutable.Stack[TreeNode]()
        var cur = root
        var remain = k
        while (stack.nonEmpty || cur != null) {
            if (cur != null) {
                stack.push(cur)
                cur = cur.left
            } else {
                cur = stack.pop
                remain -= 1
                if (remain == 0) return cur.value
                cur = cur.right
            }
        }
        -1
    }
}
