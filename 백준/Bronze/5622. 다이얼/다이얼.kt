private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var ans = 0
    br.readLine().forEach {
        when(it) {
            in "ABC" -> ans += 3
            in "DEF" -> ans += 4
            in "GHI" -> ans += 5
            in "JKL" -> ans += 6
            in "MNO" -> ans += 7
            in "PQRS" -> ans += 8
            in "TUV" -> ans += 9
            in "WXYZ" -> ans += 10
        }
    }
    write("$ans")
    close()
}