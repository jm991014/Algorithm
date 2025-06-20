import kotlin.math.pow

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val L = br.readLine().toInt()
    val s = br.readLine()
    var code = 0
    s.forEachIndexed { index, alphabet ->
        code += (alphabet.code - 96) * 31.toDouble().pow(index.toDouble()).toInt()
    }
    print(code % 1234567891)
}