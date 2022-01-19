object L205 {
    // 映射到第三个集合来比较
    def isIsomorphic(s: String, t: String): Boolean = {
        val mapA = collection.mutable.Map[Char, Int]()
        val mapB = collection.mutable.Map[Char, Int]()

        for (i <- s.indices) {
            val c1 = s(i); val c2 = t(i)
            var a = -1; var b = -1
            if (mapA.contains(c1)) {
                a = mapA(c1)
            } else {
                a = mapA.size
                mapA.addOne(c1, a)
            }
            if (mapB.contains(c2)) {
                b = mapB(c2)
            } else {
                b = mapB.size
                mapB.addOne(c2, b)
            }
            if (a != b) return false
        }
        true
    }
}