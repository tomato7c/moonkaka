object L71 {
    // 先用split分割，遇到.跳过; ..移除栈顶元素; 其他字符直接保存
    def simplifyPath(path: String): String = {
        val arr = path.split("/")
        val stack = collection.mutable.Stack[String]()
        for (i <- arr.indices) {
            val s = removePrefixSlash(arr(i))
            if (s.equals("") || s.equals(".")) {
                // do nothing
            } else if (s.equals("..")) {
                if (stack.nonEmpty) stack.pop
            } else {
                stack.push(s)
            }
        }
        "/" + stack.reverse.mkString("/")
    }

    private def removePrefixSlash(s: String): String = {
        var i = 0
        while (i < s.length && s(i) == '/') i += 1
        if (i < s.length) s.substring(i) else ""
    }
}