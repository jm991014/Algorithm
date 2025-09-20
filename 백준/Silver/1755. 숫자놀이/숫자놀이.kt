private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val numMap = mapOf('0' to "zero", '1' to "one", '2' to "two", '3' to "three", '4' to "four", '5' to "five", '6' to "six", '7' to "seven", '8' to "eight", '9' to "nine")
    val (M, N) = br.readLine().split(" ").map(String::toInt)

    val numberWords = (M..N).map { number ->
        val word = number.toString()
            .map { numMap[it] }
            .joinToString(" ")

        number to word
    }.sortedBy { it.second }

    numberWords.forEachIndexed { index, (num, _) ->
        append("$num ")
        if ((index + 1) % 10 == 0) appendLine()
    }
    println(this)
}
