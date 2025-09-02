private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    while (br.readLine() != "0") {
        val arr = br.readLine().split(" ").map(String::toInt).toIntArray()
        var peek = 0
        for (i in 1 until arr.size - 1) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) peek++
        }
        write("$peek\n")
    }
    close()
}
