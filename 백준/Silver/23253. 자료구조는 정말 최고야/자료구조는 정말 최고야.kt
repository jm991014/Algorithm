private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    var flag = 0

    repeat(M) {
        val size = br.readLine().toInt()
        val pile = br.readLine().split(" ").map { it.toInt() }
        if (pile != pile.sortedDescending()) flag = 1
    }
    if (flag == 1) append("No") else append("Yes")

    print(this)
}