class Solution {
    fun solution(k: Long, room_number: LongArray): LongArray {
        var answer = LongArray(room_number.size)
        val rooms = mutableMapOf<Long, Long>()
        
        room_number.forEachIndexed { i, room ->
            answer[i] = rooms.getNextRoom(room)
        }
        
        return answer
    }
    
    fun MutableMap<Long, Long>.getNextRoom(room: Long): Long {
        if (!containsKey(room)) {
            put(room, room + 1)
            return room
        }
        
        val nextRoom = getNextRoom(getOrDefault(room, 0L))
        
        this[room] = nextRoom + 1
        return nextRoom
    }
}