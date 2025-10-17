private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val am = (7 * 60 until 19 * 60)
    val pm = (19 * 60 until 7 * 60)
    var fee = 0

    repeat(br.readLine().toInt()) {
        val (HHMM, DD) = br.readLine().split(" ")
        val start = HHMM.split(":").map(String::toInt).let { it[0] * 60 + it[1] }

        for (i in 0 until DD.toInt()) {
            fee += if (start + i in am) 10 else 5
        }
    }
    println(fee)
}