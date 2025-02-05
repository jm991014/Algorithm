private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val (R, S) = br.readLine().split(" ")
        write("${S.map { it.toString().repeat(R.toInt()) }.joinToString("")}\n")
    }
    close()
}