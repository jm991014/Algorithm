private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val deque = ArrayDeque<Int>()

    repeat(br.readLine().toInt()) {
        val command = br.readLine().split(" ").map(String::toInt)

        when (command[0]) {
            1 -> deque.addFirst(command[1])
            2 -> deque.addLast(command[1])
            3 -> if (deque.isNotEmpty()) append("${deque.removeFirst()}\n") else append("-1\n")
            4 -> if (deque.isNotEmpty()) append("${deque.removeLast()}\n") else append("-1\n")
            5 -> append("${deque.size}\n")
            6 -> if (deque.isEmpty()) append("1\n") else append("0\n")
            7 -> if (deque.isNotEmpty()) append("${deque.first()}\n") else append("-1\n")
            8 -> if (deque.isNotEmpty()) append("${deque.last()}\n") else append("-1\n")
        }
    }
    println(this)
}
