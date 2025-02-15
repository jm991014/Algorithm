import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    while (true) {
        val str = br.readLine()
        if (str == ".") break
        write(if (isBalanced(str)) "yes\n" else "no\n")
    }
    close()
}

fun isBalanced(str: String): Boolean {
    val bracket = arrayOf('(', ')', '[', ']')
    val stack = LinkedList<Char>()
    str.filter { it in bracket}.forEach {
        when (it) {
            bracket[0], bracket[2] -> stack.push(it)
            bracket[1] -> if (stack.peek() == bracket[0]) stack.pop() else return false
            bracket[3] -> if (stack.peek() == bracket[2]) stack.pop() else return false
        }
    }
    return stack.isEmpty()
}