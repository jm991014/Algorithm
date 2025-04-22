import java.math.BigInteger
import kotlin.math.ceil

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val (B, C) = br.readLine().split(" ").map { it.toInt() }
    var count = BigInteger.ZERO

    for (i in A.indices) {
        A[i] -= B
        count = count.plus(BigInteger.ONE)
        if (A[i] > 0) {
            val left = ceil(A[i].toDouble() / C).toInt()
            A[i] -= left
            count += left.toBigInteger()
        }
    }

    write("$count")
    close()
}
