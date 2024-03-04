import java.math.*

fun main() {    
    val input = readln().toInt()
    val numarr = readln().split(" ").map { it.toInt() }
    print("${numarr.min()} ${numarr.max()}")
}