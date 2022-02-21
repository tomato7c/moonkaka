import scala.util.control.Breaks.{break, breakable}
object Solution {
    // 模拟，当某个位置受力多次时（假设经过当前时间后受力2次）则为.
    def pushDominoes(dominoes: String): String = {
        val q = collection.mutable.Queue[(Int, Int, Int)]() // (index, time, direction)
        val stressCount = new Array[Int](dominoes.length) // 受力次数
        val arr = dominoes.toArray
        for (i <- dominoes.indices if dominoes(i) != '.') {
            val direction = dominoes(i) match {
                case 'L' => -1
                case 'R' => 1
            }
            q.enqueue((i, 1, direction))
            stressCount(i) = 1
        }

        while (q.nonEmpty) {
            val size = q.size
            for (_ <- 0 until size) {
                val (index, time, direction) = q.dequeue
                val next = index + direction
                breakable({
                    // arr(index) == '.'表示在上个时刻受到两个力，没有倒
                    if (arr(index) == '.' || next < 0 || next >= dominoes.length) break 
                    if (stressCount(next) == 0) { // 首次受力
                        q.enqueue((next, time + 1, direction))
                        stressCount(next) = time + 1
                        arr(next) = direction match {
                            case -1 => 'L'
                            case 1 => 'R'
                        }
                    } else if (stressCount(next) == time + 1) { // 上次受了两种力
                        arr(next) = '.'
                    }
                })
            }
        }
        new String(arr)
    }
}