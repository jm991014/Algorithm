import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val stack = LinkedList<Char>().apply { addAll(br.readLine().map { it }) }
        if (stack[0] == ')' || stack[stack.lastIndex] == '(' || stack.size % 2 != 0) {
            write("NO\n")
            return@repeat
        }
        var count = 0
        while (stack.isNotEmpty()) {
            if (stack.pop() == '(') count++ else count--
            if (count < 0) {
                write("NO\n")
                return@repeat
            }
        }
        write("${if (count == 0) "YES" else "NO"}\n")
    }
    close()
}