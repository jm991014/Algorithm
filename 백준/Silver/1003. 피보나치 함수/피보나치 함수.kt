private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val fibonacci = Array(41) { 1 to 0 }.apply {
        this[1] = 0 to 1
    }

    for (i in 2 until 41) {
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]
    }

    repeat(br.readLine().toInt()) {
        val (zeros, ones) = fibonacci[br.readLine().toInt()]
        write("$zeros $ones\n")
    }
    close()
}

operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> =
    (this.first + other.first) to (this.second + other.second)