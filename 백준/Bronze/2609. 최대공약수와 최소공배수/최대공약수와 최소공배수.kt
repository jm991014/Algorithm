private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    write("${gcd(a, b)}\n${a * b / gcd(a, b)}")
    close()
}

fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a