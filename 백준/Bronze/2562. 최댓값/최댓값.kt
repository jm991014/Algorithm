import java.math.*

fun main() {
    var arr = mutableListOf<Int>()
    repeat(9) {
        val number = readln().toInt()
        arr.add(number)
    }
    print("${arr.max()}\n${arr.indexOf(arr.max())+1}")
}