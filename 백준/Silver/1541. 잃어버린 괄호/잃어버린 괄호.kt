private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val equation = br.readLine().split("-")
    var ans = equation.first().split("+").sumOf { it.toInt() }

    for (i in 1 until equation.size) {
        ans -= equation[i].split("+").sumOf { it.toInt() }
    }
    write("$ans")
    close()
}