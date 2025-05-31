private val br = System.`in`.bufferedReader()

private data class Truck(var pos: Int, val weight: Int)

fun main() = with(System.out.bufferedWriter()) {
    val (n, w, L) = br.readLine().split(" ").map { it.toInt() }
    val trucks = br.readLine().split(" ").map { Truck(0, it.toInt()) }

    var crossed = 0
    var totalTime = 0
    var totalWeight = 0
    var idx = 0

    while (crossed < n) {
        if (idx < n && totalWeight + trucks[idx].weight <= L) totalWeight += trucks[idx++].weight

        for (i in crossed until idx) {
            trucks[i].pos++
            if (trucks[i].pos == w) {
                totalWeight -= trucks[i].weight
                crossed++
            }
        }
        totalTime++
    }
    write("${++totalTime}")
    close()
}
