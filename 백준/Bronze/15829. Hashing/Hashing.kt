import java.math.BigInteger

private val br = System.`in`.bufferedReader()
private val base = BigInteger.valueOf(31)
private val mod =  BigInteger.valueOf(1234567891)
private var code = BigInteger.ZERO

fun main() = with(System.out.bufferedWriter()) {
    val L = br.readLine().toInt()
    val s = br.readLine()

    s.forEachIndexed { index, alphabet ->
        val power = base.pow(index)
        code += BigInteger.valueOf((alphabet.code - 96).toLong()).multiply(power)
    }
    write("${code % mod}")
    close()
}