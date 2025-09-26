private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val size = br.readLine().toInt()
    val stst = br.readLine().toMutableList()
    var s = stst.count { it == 's' }
    var t = stst.count { it == 't' }

    while (true) {
        if (s != t) {
            val removed = stst.removeFirst()
            if (removed == 's') s-- else t--
        } else {
            append(stst.joinToString(""))
            break
        }
    }
    print(this)
}