import java.util.LinkedList

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var newS = s

        repeat(s.length) {
            if (newS.check()) answer++
            newS = newS.rotate()
        }
        return answer
    }

    fun String.rotate(): String {
        if (this.isEmpty()) return ""
        val lastIndex = this.length - 1
        return this.substring(1..lastIndex) + this.first()
    }

    fun String.check(): Boolean {
        val open = arrayOf('[', '{', '(')
        val close = arrayOf(']', '}', ')')
        val stack = LinkedList<Char>()

        if (this.isEmpty() || this.first() in close) return false

        this.forEach {
            if (it in open) stack.push(it)
            else {
                if (stack.isNotEmpty()) {
                    val peek = stack.peek()
                    when {
                        it == ']' && peek == '[' -> stack.pop()
                        it == '}' && peek == '{' -> stack.pop()
                        it == ')' && peek == '(' -> stack.pop()
                        else -> return false
                    }
                } else return false
            }
        }
        return stack.isEmpty()
    }
}