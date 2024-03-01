fun main() {
    val x = readln().toInt()
    val y = readln().toInt()
    when {
        (x > 0 && y > 0) -> print("1")
        (x < 0 && y > 0) -> print("2")
        (x < 0 && y < 0) -> print("3")
        (x > 0 && y < 0) -> print("4")
    }
}