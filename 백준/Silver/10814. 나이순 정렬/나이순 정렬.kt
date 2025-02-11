private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val case = br.readLine().toInt()
    val arr = Array(case) { br.readLine().split(" ").let { (age, name) -> Triple(age.toInt(), name, it) } }
    arr.sortedWith(compareBy<Triple<Int, String, Int>> { it.first }.thenBy { it.third }).forEach {
        write("${it.first} ${it.second}\n")
    }
    close()
}