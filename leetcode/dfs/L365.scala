object Solution {

    private var visited: collection.mutable.Set[(Int, Int)] = null
    private var x = -1
    private var y = -1

    // 8种状态dfs
    // 1. x装满  2. x倒空
    // 3. y装满  4. y倒空
    // 5. x全部倒入y 6. x部分倒入y,使y满
    // 7. y全部倒入x 8. y部分倒入x,使x满
    def canMeasureWater_v1(_x: Int, _y: Int, z: Int): Boolean = {
        visited = collection.mutable.Set[(Int, Int)]()
        x = _x; y = _y
        dfs((0, 0), z)
    }

    private def dfs(state: (Int, Int), z: Int): Boolean = {
        if (visited.contains(state)) {
            return false // 去重
        } else {
            visited += state
        }
        
        val remainX = state._1; val remainY = state._2
        if (remainX == z || remainY == z || remainX + remainY == z) return true
        // 1.x装满
        val state1 = (x, remainY)
        if (dfs(state1, z)) return true
        // 2. x倒空
        val state2 = (0, remainY)
        if (dfs(state2, z)) return true
        // 3. y装满
        val state3 = (remainX, y)
        if (dfs(state3, z)) return true
        // 4. y倒空
        val state4 = (remainX, 0)
        if (dfs(state4, z)) return true
        // 5. x全部倒入y
        val state5 = (0, remainY + remainX)
        if (remainX <= y - remainY && dfs(state5, z)) return true
        // 6. x部分倒入y
        val state6 = (remainX - y + remainY, y)
        if (remainX > y - remainY && dfs(state6, z)) return true
        // 7. y全部倒入x
        val state7 = (remainX + remainY, 0)
        if (remainY <= x - remainX && dfs(state7, z)) return true
        // y部分倒入x
        val state8 = (x, remainY - x + remainX)
        if (remainY > x - remainX && dfs(state8, z)) return true
        // 当前节点得不到答案
        false
    }

    def canMeasureWater_v2(x: Int, y: Int, z: Int): Boolean = {
        val visited = collection.mutable.Set[(Int, Int)]()
        val stack = collection.mutable.Stack[(Int, Int)]()
        stack.push((0, 0))
        while (stack.nonEmpty) {
            val cur = stack.pop
            if (!visited.contains(cur)) {
                visited += cur
                val remainX = cur._1; val remainY = cur._2
                if (remainX == z || remainY == z || remainX + remainY == z) return true
                // 1. x满
                stack.push((x, remainY))
                // 2. x空
                stack.push((0, remainY))
                // 3. y满
                stack.push((remainX, y))
                // 4. y空
                stack.push((remainX, 0))
                // 5. x全部倒入y
                if (remainX <= y - remainY) stack.push((0, remainY + remainX))
                // 6. x部分倒入y
                if (remainX > y - remainY) stack.push((remainX - y + remainY, y))
                // 7. y全部倒入x
                if (remainY <= x - remainX) stack.push((remainX + remainY, 0))
                // 8. y部分倒入x
                if (remainY > x - remainX) stack.push((x, y - x + remainX))
            }
        }
        false
    }
}