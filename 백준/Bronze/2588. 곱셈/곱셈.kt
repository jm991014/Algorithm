fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    println(a * (b % 10))
    println(a * ((b / 10) % 10))
    println(a * (b / 100))
    println(a * b)
}