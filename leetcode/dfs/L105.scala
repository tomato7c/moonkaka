object L105 {

    private var mapToIndex: collection.mutable.Map[Int, Int] = null

    def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
        mapToIndex = collection.mutable.Map[Int, Int]()
        for (i <- inorder.indices) mapToIndex.addOne(inorder(i), i)

        dfs(preorder, 0, preorder.length - 1, 0)
    }

    // start,end表示先序遍历中该子树节点范围，inL表示中序遍历中该子树的最左位置(主要用来计算左子树大小)
    private def dfs(pre: Array[Int], start: Int, end: Int, inL: Int): TreeNode = {
        if (start > end) return null

        val root = new TreeNode(pre(start))
        val inOrderIdx = mapToIndex(pre(start))
        val leftSize = inOrderIdx - inL
        
        root.left = dfs(pre, start + 1, start + leftSize, inL)
        root.right = dfs(pre, start + leftSize + 1, end, inOrderIdx + 1)
        root
    }
}