private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val S = br.readLine()

    var cnt = 0; var result = 0; var i = 0
    
    while (i <= M - 3) {
        if (S[i] == 'I' && S[i + 1] == 'O' && S[i + 2] == 'I') {
            cnt++
            i += 2
            if (cnt >= N) result++
        } else {
            cnt = 0
            i++
        }
    }
    write(result.toString())
    close()
}