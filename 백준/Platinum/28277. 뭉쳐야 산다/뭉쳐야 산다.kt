private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val (N, Q) = br.readLine().split(" ").map(String::toInt)
    val sets = Array(N) { br.readLine().split(" ").drop(1).map(String::toInt).toMutableSet() }
    val index = IntArray(N) { it }

    repeat(Q) {
        val command = br.readLine().split(" ").map(String::toInt)

        if (command.first() == 2) append(sets[command[1] - 1].size).appendLine()
        else {
            val (from, to) = command.subList(1, 3).map { it - 1 }

            if (sets[index[from]].size < sets[index[to]].size) {
                sets[from] = sets[to].also { sets[to] = sets[from] }
            }

            sets[index[from]].addAll(sets[index[to]])
            sets[index[to]].clear()
        }
    }
    println(this)
}
