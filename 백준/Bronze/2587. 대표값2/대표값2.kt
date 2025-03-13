private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val arr = IntArray(5)
    repeat(5) {
        arr[it] = br.readLine().toInt()
    }
    arr.sort()
    write("${arr.average().toInt()}\n${arr[2]}")
    close()
}