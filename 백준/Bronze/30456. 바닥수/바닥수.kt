private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val (N, L) = br.readLine().split(" ").map { it.toInt() }
    repeat(L - 1) { append('1') }
    append(N)
    print(this)
}