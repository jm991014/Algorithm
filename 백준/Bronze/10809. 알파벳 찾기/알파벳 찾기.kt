private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val str = br.readLine()
    val alphabet = IntArray(26) { -1 }
    str.forEachIndexed { index, alpha ->
        if (alphabet[alpha.code - 97] == -1) alphabet[alpha.code - 97] = index
    }
    alphabet.forEach {
        write("$it ")
    }
    close()
}