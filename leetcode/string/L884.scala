object Solution {
  def uncommonFromSentences(s1: String, s2: String): Array[String] = {
    var list = s1.split(" ").filterNot(_.isEmpty).toList
    list = list.concat(s2.split(" ").filterNot(_.isEmpty))
    val map = collection.mutable.Map[String, Int]()

    for (s <- list) {
      if (map.contains(s)) {
        map += (s -> (map(s) + 1))
      } else {
        map += (s -> 1)
      }
    }
    map.filter(it => it._2 == 1).keys.toArray
  }
}