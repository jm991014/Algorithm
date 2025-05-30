private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val course = Array(20) { br.readLine().split(" ").let { it[1].toDouble() to it[2] } }

    var grade = 0.0
    var credits = 0.0
    course.forEach {
        when (it.second) {
            "A+" -> grade += 4.5 * it.first
            "A0" -> grade += 4.0 * it.first
            "B+" -> grade += 3.5 * it.first
            "B0" -> grade += 3.0 * it.first
            "C+" -> grade += 2.5 * it.first
            "C0" -> grade += 2.0 * it.first
            "D+" -> grade += 1.5 * it.first
            "D0" -> grade += 1.0 * it.first
            "F" -> grade += 0 * it.first
        }
        if (it.second != "P") credits += it.first
    }
    write("%.6f".format(grade / credits))
    close()
}