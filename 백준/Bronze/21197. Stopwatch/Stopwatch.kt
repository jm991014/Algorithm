private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val size = br.readLine().toInt()
    val arr = Array(size) { br.readLine().toInt() }
    
    if (size % 2 == 1) write("still running")
    else {
        var total = 0
        var tmp = 0
        arr.forEachIndexed { index, i ->
            if (index % 2 == 0) tmp = i
            else {
                total += i - tmp
            }
        }
        write("$total")
    }
    close()
}
