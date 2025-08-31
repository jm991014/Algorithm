import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val stack = LinkedList<Int>()
    repeat(br.readLine().toInt()) {
        val command = br.readLine()

        when (command[0]) {
            '1' -> {
                stack.push(command.substring(2).toInt())
            }
            '2' -> {
                if (stack.isNotEmpty()) write("${stack.pop()}\n")
                else write("-1\n")
            }
            '3' -> {
                write("${stack.size}\n")
            }
            '4' -> {
                if (stack.isNotEmpty()) write("0\n")
                else write("1\n")
            }
            '5' -> {
                if (stack.isNotEmpty()) write("${stack.peek()}\n")
                else write("-1\n")
            }
        }
    }
    close()
}
