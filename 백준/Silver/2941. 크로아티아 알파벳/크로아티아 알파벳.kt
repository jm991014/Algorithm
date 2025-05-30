private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val croatia = arrayOf("dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=")
    var input = br.readLine()

    croatia.forEach { c ->
        input = input.replace(c, "0")
    }
    write("${input.length}")
    close()
}