private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val quiz = br.readLine()
        var score = 0
        var weight = 1
        quiz.forEach {
            if (it == 'O') score += weight++
            else weight = 1
        }
        write("$score\n")
    }
    close()
}