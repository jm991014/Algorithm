import java.io.BufferedReader
import java.io.BufferedWriter

private val br = BufferedReader(System.`in`.bufferedReader())

fun main() = with(BufferedWriter(System.out.bufferedWriter())) {
    val (player, game) = br.readLine().split(" ")
    val playerName = mutableSetOf<String>()

    repeat(player.toInt()) {
        playerName.add(br.readLine())
    }
    
    val divider = when (game) {
        "Y" -> 1
        "F" -> 2
        else -> 3
    }

    write("${playerName.size / divider}")
    close()
}