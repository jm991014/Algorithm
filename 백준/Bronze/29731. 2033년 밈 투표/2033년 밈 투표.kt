private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val promise = setOf(
        "Never gonna give you up", "Never gonna let you down",
        "Never gonna run around and desert you",
        "Never gonna make you cry",
        "Never gonna say goodbye",
        "Never gonna tell a lie and hurt you",
        "Never gonna stop"
    )

    val input = Array(br.readLine().toInt()) { br.readLine() }

    write(if (input.all { it in promise }) "No" else "Yes")
    close()
}