private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val set = mutableSetOf<Int>()
    repeat(br.readLine().toInt()) {
        val command = br.readLine()
        when {
            command.startsWith("ad") -> set.add(command.split(" ")[1].toInt())
            command[0] == 'c' -> write(if (set.contains(command.split(" ")[1].toInt())) "1\n" else "0\n")
            command[0] == 'r' -> set.removeIf { it == command.split(" ")[1].toInt() }
            command[0] == 't' -> {
                val num = command.split(" ")[1].toInt()
                if (set.contains(num)) set.remove(num) else set.add(num)
            }
            command[0] == 'e' -> set.clear()
            else -> (1..20).forEach { set.add(it) }
        }
    }
    close()
}