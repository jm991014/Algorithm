private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var (N, B) = br.readLine().split(" ").map(String::toInt)
    val digit = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    var ans = ""
    while (N > 0) {
        ans += digit[N % B]
        N /= B
    }
    write(ans.reversed())
    close()
}
