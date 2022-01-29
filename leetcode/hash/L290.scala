object Solution {
    def wordPattern(p: String, _s: String): Boolean = {
        val s = _s.split(" ").filter(!_.isEmpty)
        if (p.length != s.length) return false
        var pCount, sCount = 0
        val pBuilder, sBuilder = new StringBuilder()
        val pMap = collection.mutable.Map[Char, Int]()
        val sMap = collection.mutable.Map[String, Int]()

        for (i <- p.indices) {
            if (!pMap.contains(p(i))) {
                pMap += (p(i) -> pCount)
                pCount += 1
            }
            if (!sMap.contains(s(i))) {
                sMap += (s(i) -> sCount)
                sCount += 1
            }
            if (!pMap(p(i)).equals(sMap(s(i)))) return false
        }
        true
    }
}