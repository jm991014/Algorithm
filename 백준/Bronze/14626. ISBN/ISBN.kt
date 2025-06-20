private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val isbn = br.readLine().toCharArray()
    var sum = 0
    var missing = 0

    isbn.forEachIndexed { index, code ->
        if (code.isDigit()) {
            sum += if (index % 2 == 0) code.digitToInt() else code.digitToInt() * 3
        } else missing = index
    }

    val weight = if (missing % 2 == 0) 1 else 3
    val target = (10 - sum % 10) % 10
    write("${(target * if (weight == 3) 7 else 1) % 10}")
    close()
}