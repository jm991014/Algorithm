private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    repeat(br.readLine().toInt()) {
        val (p, t) = br.readLine()!!.split(' ').map { it.toInt() }
        append(p - (t / 7) + (t / 4))
        appendLine()
    }
    print(this)
}