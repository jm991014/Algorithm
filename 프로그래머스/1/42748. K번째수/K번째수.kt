class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map { command ->
            array.slice(command[0]-1..command[1]-1).sorted()[command[2] - 1]
        }.toIntArray()
    }
}