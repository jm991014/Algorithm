private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    while(true) {
        val num = br.readLine()
        if (num == "0") break
        write(if (num.reversed() == num) "yes\n" else "no\n")
    }
    close()
}