import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val stack = LinkedList<Int>()
    repeat(br.readLine().toInt()) {
        val num = br.readLine().toInt()
        if (num != 0) stack.push(num) else stack.pop()
    }
    write("${stack.sum()}")
    close()
}