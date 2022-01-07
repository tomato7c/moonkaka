/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object L99 {
    def recoverTree(root: TreeNode): Unit = {
        val _res = collection.mutable.ListBuffer[TreeNode]()
        dfs(root, _res)
        val res = _res.toList

        if (res.length < 2) return
        var l = 0; var r = res.length - 1
        while (res(l).value < res(l + 1).value) l += 1
        while (res(r).value > res(r - 1).value) r -= 1

        val temp = res(l).value
        res(l).value = res(r).value
        res(r).value = temp
    }

    private def dfs(root: TreeNode, res: collection.mutable.ListBuffer[TreeNode]) {
        if (root == null) return
        dfs(root.left, res)
        res += root
        dfs(root.right, res)
    }
}