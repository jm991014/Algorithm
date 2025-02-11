private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val case = br.readLine().toInt()
    val arr = Array(case) { br.readLine().split(" ").let { (age, name) -> Pair(age.toInt(), name) } }
    arr.sortedWith(compareBy { it.first }).forEach { write("${it.first} ${it.second}\n") }
    close()
}