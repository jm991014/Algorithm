class Solution {
    fun solution(my_str: String, n: Int): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        answer += my_str.windowed(n, n)
        if (my_str.length % n != 0)  answer += my_str.takeLast(my_str.length % n)
        return answer
    }
}