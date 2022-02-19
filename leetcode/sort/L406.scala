import java.util
object Solution {
    // 先按身高排序，再按k排序，根据k确定插入位置
    def reconstructQueue(_people: Array[Array[Int]]): Array[Array[Int]] = {
        val res = new util.LinkedList[Array[Int]]()
        val people = _people.sortWith((a, b) => {
            if (a(0) == b(0)) {
                a(1) < b(1)
            } else {
                a(0) > b(0)
            }
        })

        for (cur <- people) {
            res.add(cur(1), cur)
        }
        res.toArray(Array[Array[Int]]())
    }
}