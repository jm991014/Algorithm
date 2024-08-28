import kotlin.math.*

fun main() {
    val (start, end) = readLine()!!.split(" ").map { it.toInt() }
    val sieve = BooleanArray(end + 1) { true }
    sieve[0] = false
    sieve[1] = false
    for (i in 2 .. sqrt(end.toDouble()).toInt()) {
        if (sieve[i]) {
            for (j in i * i..end step i) {
                sieve[j] = false
            }
        }
    }
    for(i in start..end) {
        if(sieve[i]) println(i)
    }
}