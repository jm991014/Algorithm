import java.math.*
fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val a = input[0]
    val b = input[1]
    val c = input[2]
    if(a == b && b == c && a == c) {
        print(10000 + (a * 1000))
    }
    else if(a != b && b != c && a != c) {
        print(input.max() * 100)
    } else {
        val max = if(a == b || a == c) a else b
        print(1000 + (max * 100))
    }
}