class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        commands.forEach {
            var tmp_arr = intArrayOf()
            for(i in it[0]..it[1]) {
                var tmp = array[i-1]
                tmp_arr += tmp
            }
            tmp_arr.sort()
            answer += tmp_arr[it[2]-1]
        }
        return answer
    }
}