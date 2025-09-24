private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    repeat(br.readLine().toInt()) {
        append(br.readLine().split(" ").joinToString(" ") { it.reversed() })
        appendLine()
    }
    print(this)
}