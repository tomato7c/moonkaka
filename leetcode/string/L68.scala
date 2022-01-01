object L68 {
  // 分成两步 1. 拆分单词成多行 2.对每行执行两端对齐, 注意最后一行特殊处理
  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    val res = collection.mutable.ListBuffer[String]()
    val lines = splitWithWidth(words, maxWidth)
    for (index <- 0 until lines.length - 1) {
      res += justify(lines(index)._1, lines(index)._2, maxWidth)
    }
    // add last line
    val last = new StringBuilder
    last.append(lines.last._1.mkString(" "))
    while (last.length() < maxWidth) last.append(" ")
    res.append(last.toString())
    
    res.toList
  }

  private def justify(words: List[String], wordLength: Int, maxWidth: Int): String = {
    val res = new StringBuilder
    var remainBlanks = maxWidth - wordLength
    var remainIntervals = words.length - 1
    for (w <- words) {
      res.append(w)
      if (remainIntervals > 0) {
        var blankSize = remainBlanks / remainIntervals
        if (remainBlanks % remainIntervals != 0) blankSize += 1
        remainBlanks -= blankSize
        remainIntervals -= 1
        for (temp <- 1 to blankSize) res.append(" ")
      } else {
        for (temp <- 1 to remainBlanks) res.append(" ")
      }
    }
    res.toString()
  }

  // return words per line and character size
  private def splitWithWidth(words: Array[String], maxWidth: Int): List[(List[String], Int)] = {
    val res = collection.mutable.ListBuffer[(List[String], Int)]()
    var line = collection.mutable.ListBuffer[String]()
    var lineLength = 0
    var wordLength = 0

    for (w <- words) {
      if (line.isEmpty && w.length <= maxWidth) { // 是每一行第一个单词，直接加入
        lineLength += w.length
        wordLength += w.length
        line += w
      } else if (line.nonEmpty && lineLength + w.length + 1 <= maxWidth) { // 结合空格计算出该单词可以放置在本行
        lineLength += w.length + 1
        wordLength += w.length
        line += w
      } else { // 换行放置单词
        res.addOne(line.toList, wordLength)
        lineLength = 0
        wordLength = 0
        line.clear()
        // add word
        line += w
        wordLength += w.length
        lineLength += w.length
      }
    }
    // last line
    if (line.nonEmpty) {
      res.addOne(line.toList, wordLength)
    }
    res.toList
  }
}