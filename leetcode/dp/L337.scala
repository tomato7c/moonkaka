/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    // f(node, 0)表示不选择当前节点, f(node, 1)表示(可以)选择当前节点
    // f(node,0) = max(f(x, 0), f(x, 1)) + max(f(y, 0), f(y, 1))
    // f(node, 1) = f(x, 0) + f(y, 0) + node.value
    def rob(root: TreeNode): Int = {
        val f = dfs(root)
        math.max(f._1, f._2)
    }
    
    // (rob_root, do_not_rob_root)
    private def dfs(root: TreeNode): (Int, Int) = {
        if (root == null) return (0, 0)
        val left = dfs(root.left)
        val right = dfs(root.right)
        val include = left._2 + right._2 + root.value
        val exclude = math.max(left._1, left._2) + math.max(right._1, right._2)
        (include, exclude)
    }
}