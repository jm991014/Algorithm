private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var N = 1000 - br.readLine().toInt()
    val money = arrayOf(500, 100, 50, 10, 5, 1)
    var count = 0

    while (N > 0) {
        when {
            N >= money[0] -> N -= money[0]
            N >= money[1] -> N -= money[1]
            N >= money[2] -> N -= money[2]
            N >= money[3] -> N -= money[3]
            N >= money[4] -> N -= money[4]
            N >= money[5] -> N -= money[5]
        }
        count++
    }
    write("$count")
    close()
}