import scala.collection.mutable
class Twitter() {
    // userId -> twitter
    val twitterMap = mutable.Map[Int, Tweet]()
    // userId -> userIds
    val followMap = mutable.Map[Int, mutable.Set[Int]]()

    var globalTimestamp = 0

    def postTweet(userId: Int, tweetId: Int) {
        val newHead = new Tweet(tweetId, globalTimestamp)
        if (twitterMap.contains(userId)) {
            val oldHead = twitterMap(userId)
            newHead.next = oldHead
        }
        twitterMap += (userId -> newHead)

        globalTimestamp += 1
    }

    def getNewsFeed(userId: Int): List[Int] = {
        val maxHeap = mutable.PriorityQueue[Tweet]()(Ordering.by(_.timestamp))

        if (twitterMap.contains(userId)) maxHeap.enqueue(twitterMap(userId))

        if (followMap.contains(userId)) {
            for (userId <- followMap(userId) if twitterMap.contains(userId)) {
                maxHeap += twitterMap(userId)
            }
        }
        val res = mutable.ListBuffer[Int]()
        while (maxHeap.nonEmpty && res.size < 10) {
            val cur = maxHeap.dequeue
            res += cur.id
            if (cur.next != null) maxHeap.enqueue(cur.next)
        }
        res.toList
    }

    def follow(followerId: Int, followeeId: Int) {
        var followeeSet: mutable.Set[Int] = null
        if (!followMap.contains(followerId)) {
            followeeSet = mutable.Set[Int]()
        } else {
            followeeSet = followMap(followerId)
        }
        followeeSet += followeeId
        followMap += (followerId -> followeeSet)
    }

    def unfollow(followerId: Int, followeeId: Int) {
        if (followMap.contains(followerId)) {
            followMap(followerId) -= followeeId
        }
    }

    class Tweet(val id: Int, val timestamp: Int) {
        var next: Tweet = null
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = new Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */