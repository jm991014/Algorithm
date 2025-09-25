private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val names = Array(br.readLine().toInt()) { br.readLine() }.toSet()
    if (names.contains("anj")) append("뭐야;") else append("뭐야?")
    print(this)
}