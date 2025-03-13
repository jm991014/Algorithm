private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val arr = IntArray(N)
    repeat(N) {
        arr[it] = br.readLine().toInt()
    }

    write(arr.sorted().joinToString("\n"))
    close()
}