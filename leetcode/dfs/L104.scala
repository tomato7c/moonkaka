object L104 {

    def maxDepth_v1(root: TreeNode): Int = {
        if (root == null) return 0
        1 + Math.max(maxDepth(root.left), maxDepth(root.right))
    }

    def maxDepth_v2(root: TreeNode): Int = {
    	// BFS
    	0
    }



}