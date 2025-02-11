class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val giveMap = HashMap<String, List<String>>()
        val receiveMap = HashMap<String, List<String>>()
        val nextMonth = HashMap<String, Int>()

        gifts.forEach {
            val (give, receive) = it.split(" ")
            giveMap[give] = giveMap.getOrDefault(give, emptyList()) + receive
            receiveMap[receive] = receiveMap.getOrDefault(receive, emptyList()) + give
        }

        friends.forEach { giver ->
            val given = giveMap.getOrDefault(giver, emptyList())
            val received = receiveMap.getOrDefault(giver, emptyList())
            for (friend in friends) {
                if (friend == giver) continue
                else {
                    if (given.count { it == friend } > received.count { it == friend }) nextMonth[giver] =
                        nextMonth.getOrDefault(giver, 0) + 1
                    else if (given.count { it == friend } == received.count { it == friend } && (given.size - received.size) > (giveMap.getOrDefault(
                            friend, emptyList()
                        ).size - receiveMap.getOrDefault(friend, emptyList()).size)) nextMonth[giver] =
                        nextMonth.getOrDefault(giver, 0) + 1
                }
            }
        }
        return nextMonth.values.maxByOrNull { it } ?: 0
    }
}