class LRUCache(_capacity: Int) {

  private var cache: collection.mutable.Map[Int, Node] = null

  private var head: Node = null

  private var tail: Node = null

  private var size: Int = 0

  {
    cache = collection.mutable.Map[Int, Node]()
    head = new Node(-1, -1, null, tail)
    tail = new Node(-1, -1, head, null)
    head.next = tail
  }

  def get(key: Int): Int = {
    if (cache.contains(key)) {
      val v = cache(key)
      moveToHead(v)
      v.value
    } else {
      -1
    }
  }

  def put(key: Int, value: Int): Unit = {
    if (cache.contains(key)) {
      val old = cache(key)
      old.value = value
      moveToHead(old)
    } else {
      if (size + 1 > _capacity) {
        cache -= remove(tail.pre).key
        size -= 1
      }

      val newNode = new Node(key, value, null, null)
      cache += (key -> newNode)
      addToHead(newNode)
      size += 1
    }
  }

  private def moveToHead(node: Node): Unit = {
    remove(node)
    addToHead(node)
  }

  private def addToHead(node: Node): Unit = {
    val next = head.next
    val pre = head

    node.pre = pre
    node.next = next
    pre.next = node
    next.pre = node
  }

  private def remove(node: Node): Node = {
    val pre = node.pre
    val next = node.next
    pre.next = next
    next.pre = pre

    node
  }

  class Node(var key: Int, var value: Int, var pre: Node, var next: Node)
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */