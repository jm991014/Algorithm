private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val options = Array(N) { br.readLine() }
    val commands = mutableSetOf<Char>()

    outer@ for (option in options) {
        val splitted = option.split(" ").toMutableList()

        for ((index, word) in splitted.withIndex()) {
            if (commands.add(word[0].lowercaseChar())) {
                splitted[index] = "[${word[0]}]${word.substring(1)}"
                write("${splitted.joinToString(" ")}\n")
                continue@outer
            }
        }

        for ((index, word) in option.withIndex()) {
            if (word != ' ' && commands.add(word.lowercaseChar())) {
                write("${option.take(index)}[${word}]${option.substring(index + 1)}\n")
                continue@outer
            }
        }
        write("${splitted.joinToString(" ")}\n")
    }
    close()
}
