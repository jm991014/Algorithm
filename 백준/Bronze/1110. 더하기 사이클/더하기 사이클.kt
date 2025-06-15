private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var num = br.readLine()
    if (num.length == 1) num = "0$num"
    
    val origin = num
    var cnt = 0

    do {
        val sum = num[0].digitToInt() + num[1].digitToInt()
        num = "${num[1]}${sum % 10}"
        cnt++
    } while (num != origin)
    
    write("$cnt")
    close()
}
