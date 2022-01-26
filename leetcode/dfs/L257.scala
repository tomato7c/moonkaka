/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {

    private var res: collection.mutable.ListBuffer[String] = null

    private var path: collection.mutable.Stack[Int] = null

    def binaryTreePaths(root: TreeNode): List[String] = {
        res = collection.mutable.ListBuffer[String]()
        path = collection.mutable.Stack[Int]()
        dfs(root)
        res.toList
    }

    private def dfs(root: TreeNode): Unit = {
        path.push(root.value)
        if (root.left == null && root.right == null) {
            res += path.toList.reverse.mkString("->")
        } else {
            if (root.left != null) dfs(root.left)
            if (root.right != null) dfs(root.right)
        }
        path.pop
    }
}
