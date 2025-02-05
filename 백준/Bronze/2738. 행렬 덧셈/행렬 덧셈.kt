private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (row, column) = br.readLine().split(" ").map { it.toInt() }
    val matrix1 = Array(row){ IntArray(column) }
    val matrix2 = Array(row){ IntArray(column) }
    repeat(row) { matrix1[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    repeat(row) { matrix2[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    repeat(row) { r ->
        repeat(column) { c ->
            write("${matrix1[r][c] + matrix2[r][c]} ")
        }
        write("\n")
    }
    close()
}
