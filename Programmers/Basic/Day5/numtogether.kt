class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        var odd: String = ""
        var even: String = ""
        num_list.forEach {
            if(it % 2 == 0) even += it.toString()
            else odd += it.toString()
        }
        answer = even.toInt() + odd.toInt()
        return answer
    }
}
// %2로 홀짝 나눠서 string화 해서 +로 붙이고 다시 int화 하기
// fun solution(numList: IntArray) = numList.partition { it % 2 == 0 }.toList().sumOf { it.joinToString("").toInt() }

fun main() {
    print(Solution().solution(intArrayOf(3, 4, 5, 2, 1)))
}