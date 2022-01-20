import scala.collection.mutable.ListBuffer
object L1345 {
  def minJumps(arr: Array[Int]): Int = {
    val n = arr.length
    val indicesOfValue = arr.indices.groupBy(arr(_)).map(e => (e._1, ListBuffer.from(e._2)))

    val visited = new Array[Boolean](n); visited(0) = true
    val q = collection.mutable.Queue[Int](); q.enqueue(0)
    var step = 0
    while (q.nonEmpty) {
      val size = q.size
      for (temp <- 0 until size) {
        val idx = q.dequeue()
        if (idx == n - 1) return step
        val list = indicesOfValue(arr(idx))
        if (idx - 1 >= 0) list += idx - 1
        if (idx + 1 < n) list += idx + 1
        list.filter(!visited(_)).foreach(it => {
          visited(it) = true
          q.enqueue(it)
        })
        list.clear() // avoid later lookup indicesOfValue arr[i]
      }
      step += 1
    }
    -1
  }
}