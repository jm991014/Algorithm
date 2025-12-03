private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val input = br.readLine().toInt()
    val case1 = input - (input * 22 / 100)
    val case2 = input - ((input * 20 / 100) * 22 / 100)

    write("$case1 $case2")
    close()
}