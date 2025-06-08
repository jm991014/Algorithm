private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (S, P) = br.readLine().split(" ").map { it.toInt() }
    val dna = br.readLine()
    val required = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val check = IntArray(4)
    var ans = 0

    for (i in 0 until P) {
        check.addChar(dna[i])
    }

    if (check.isValid(required)) ans++

    for (i in P until S) {
        check.addChar(dna[i])
        check.removeChar(dna[i - P])
        if (check.isValid(required)) ans++
    }

    write("$ans")
    close()
}

private fun IntArray.addChar(c: Char) {
    when (c) {
        'A' -> this[0]++
        'C' -> this[1]++
        'G' -> this[2]++
        'T' -> this[3]++
    }
}

private fun IntArray.removeChar(c: Char) {
    when (c) {
        'A' -> this[0]--
        'C' -> this[1]--
        'G' -> this[2]--
        'T' -> this[3]--
    }
}

private fun IntArray.isValid(target: IntArray): Boolean {
    for (i in 0 until 4) {
        if (this[i] < target[i]) return false
    }
    return true
}
