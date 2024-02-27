fun main() {
    val input = readLine()!!.split(" ")
    val num1 = input[0].toInt()
    val num2 = input[1].toInt()
    val num3 = input[2].toInt()
    println("${(num1 + num2) % num3}")
    println("${((num1 % num3) + (num2 % num3)) % num3}")
    println("${(num1 * num2) % num3}")
    println("${((num1 % num3) * (num2 % num3)) % num3}")
}