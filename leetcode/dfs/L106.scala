object L106 {

    private var mapToIndex: collection.mutable.Map[Int, Int] = null
    // 模仿先序遍历
    def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
        mapToIndex = collection.mutable.Map[Int, Int]()
        val pre  = postorder.reverse
        for (i <- inorder.indices) mapToIndex.addOne(inorder(i), i)

        dfs(pre, 0, pre.length - 1, inorder.length - 1)
    }
    
    private def dfs(pre: Array[Int], start: Int, end: Int, inR: Int): TreeNode = {
        if (start > end) return null
        if (start == end) return new TreeNode(pre(start))
        val root = new TreeNode(pre(start))
        val index = mapToIndex(pre(start))
        val rightSize = inR - index

        root.right = dfs(pre, start + 1, start + rightSize, inR)
        root.left = dfs(pre, start + rightSize + 1, end, index - 1)
        root
    }
}