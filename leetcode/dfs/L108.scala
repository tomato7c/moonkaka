object L108 {
    def sortedArrayToBST(arr: Array[Int]): TreeNode = {
        def dfs(start: Int, end: Int): TreeNode = {
            if (start > end) return null
            val mid = start + end >>> 1
            val root = new TreeNode(arr(mid))
            root.left = dfs(start, mid - 1)
            root.right = dfs(mid + 1, end)
            root
        }
        dfs(0, arr.length - 1)
    }
}