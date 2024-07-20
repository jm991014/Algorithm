class Solution {
    fun findTheWinner(n: Int, k: Int): Int {
        val friendList = mutableListOf<Int>()
        for(i in 1..n) friendList.add(i)

        var startIndex = 0
        while(friendList.size > 1) {
            val removeIndex = (startIndex + k - 1) % friendList.size
            friendList.removeAt(removeIndex)
            startIndex = removeIndex
        }
        return friendList[0]
    }
}