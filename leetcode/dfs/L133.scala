object L133 {
    //dfs
    def cloneGraph(graph: Node): Node = {
        val map = collection.mutable.Map[Node, Node]()
        def dfs(old: Node): Node = {// return new Node
            if (map.contains(old)) return map(old)
            val newNode = new Node(old.value)
            map += (old -> newNode)
            newNode.neighbors = old.neighbors.map(dfs(_))
            newNode
        }
        
        if (graph == null) graph else dfs(graph)
    }
}