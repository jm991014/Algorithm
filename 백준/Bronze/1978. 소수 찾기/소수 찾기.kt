private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var count = 0
    br.readLine()
    val num = br.readLine().split(" ").map { it.toInt() }
    num.forEach { if (isPrime(it)) count++ }
    write("$count")
    close()
}

fun isPrime(num: Int): Boolean {
    if (num == 0 || num == 1) return false
    for (i in 2 until num) if (num % i == 0) return false
    return true
}