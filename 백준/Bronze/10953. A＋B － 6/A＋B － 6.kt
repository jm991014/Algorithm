import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val case = scanner.nextInt()
    repeat(case) {
        val input = scanner.next().split(",").map { it.toInt() }
        val num1 = input[0]
        val num2 = input[1]
        println(num1 + num2)
    }
}