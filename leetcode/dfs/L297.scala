/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.Queue
class Codec {
    // Encodes a list of strings to a single string.
    def serialize(root: TreeNode): String = {
        if (root == null) {
            return "null"
        }
        s"${root.value}#${serialize(root.left)}#${serialize(root.right)}"
    }
    
    // Decodes a single string to a list of strings.
    def deserialize(data: String): TreeNode = {
        val q = Queue[String]()
        q.enqueueAll(data.split("#"))
        dfs(q)
    }

    private def dfs(q: Queue[String]): TreeNode = {
        val v = q.dequeue
        if (v.equals("null")) {
            return null
        }
        val root = new TreeNode(v.toInt)
        root.left = dfs(q)
        root.right = dfs(q)
        root
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = new Codec()
 * var deser = new Codec()
 * val s = ser.serialize(root)
 * val ans = deser.deserialize(s)
 */