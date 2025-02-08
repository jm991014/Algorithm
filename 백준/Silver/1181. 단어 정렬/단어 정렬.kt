private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var word = arrayOf<String>()

    repeat(br.readLine().toInt()) {
        word += br.readLine()
    }
    word.toSet().sortedWith(compareBy<String> { it.length }.thenBy { it }).forEach {
        write("$it\n")
    }
    close()
}