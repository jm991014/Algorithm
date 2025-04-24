private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val tPeople = br.readLine().split(" ").map { it.toInt() }.drop(1).toMutableSet()
    val party = Array(M) { br.readLine().split(" ").map { it.toInt() }.drop(1) }

    if (tPeople.isEmpty()) write("$M")
    else {
        repeat(M) {
            party.forEach {
                if (it.any { tPeople.contains(it) }) tPeople.addAll(it)
            }
        }
        write("${M - party.count { tPeople.containsAll(it) }}")
    }
    close()
}
