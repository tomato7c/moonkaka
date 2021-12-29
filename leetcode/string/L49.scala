object L49 {
    def groupAnagrams(strs: Array[String]): List[List[String]] = {
        strs.groupBy(s => s.sortWith(_<_)).values.map(it => it.toList).toList
    }
}