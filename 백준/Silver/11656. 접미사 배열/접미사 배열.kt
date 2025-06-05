private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val s = br.readLine()
    val words = mutableSetOf<String>()
    repeat(s.length) {
        words.add(s.slice(it until s.length))
    }
    words.toSortedSet().forEach {
        write("${it}\n")
    }
    close()
}
