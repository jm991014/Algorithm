import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val stack = LinkedList<Int>()
    val nums = IntArray(readLine().toInt()) { readLine().toInt() }
    var current = 1

    nums.forEach { num ->
        while (current <= num) {
            stack.push(current++)
            sb.append("+\n")
        }

        if (stack.isNotEmpty() && stack.peek() == num) {
            stack.pop()
            sb.append("-\n")
        } else {
            println("NO")
            return
        }
    }
    println(sb)
}