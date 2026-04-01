import kotlin.math.abs

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val a = IntArray(26)
    br.readLine().forEach { a[it - 'a']++ }
    br.readLine().forEach { a[it - 'a']-- }
    bw.write("${a.sumOf { abs(it) }}")
    bw.close()
}
