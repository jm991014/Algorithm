import java.util.LinkedList

class Solution {
    fun solution(order: IntArray): Int {
        val stack = LinkedList<Int>().apply { addAll(1..order.size + 1) }
        val sub = LinkedList<Int>()
        var answer: Int = 0

        while (true) {
            when {
                stack.isEmpty() || answer == order.size -> break
                stack.peek() == order[answer] -> {
                    stack.pop()
                    answer++
                }
                sub.peek() == order[answer] -> {
                    sub.pop()
                    answer++
                }
                else -> {
                    val next = stack.pop()
                    sub.push(next)
                }
            }
        }
        return answer
    }
}