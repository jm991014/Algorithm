private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val eggplant = Array(10) { br.readLine().split(" ") }
    var result = 0

    eggplant.forEach {
        if (it.groupingBy { it }.eachCount().size == 1) result = 1
    }

    val transposed = Array(10) { c -> Array(10) { r -> eggplant[r][c] } }

    transposed.forEach {
        if (it.groupingBy { it }.eachCount().size == 1) result = 1
    }

    write("$result")
    close()
}
