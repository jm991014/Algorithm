private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    var room = 1
    var layer = 1

    if (N == 1) write("1")
    else {
        while (room < N) {
            layer++
            room += 6 * (layer - 1)
        }
        write("$layer")
    }
    close()
}