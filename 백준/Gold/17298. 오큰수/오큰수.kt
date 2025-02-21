import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val stack = LinkedList<Int>()

    for (i in A.indices) {
        while (stack.isNotEmpty() && A[stack.peek()] < A[i]) {
            A[stack.pop()] = A[i]
        }
        stack.push(i)
    }

    while (stack.isNotEmpty()) {
        A[stack.pop()] = -1
    }

    A.forEach { write("$it ") }
    close()
}