private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val scale = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    when {
        scale.contentEquals(scale.sortedArray()) -> write("ascending")
        scale.contentEquals(scale.sortedArrayDescending()) -> write("descending")
        else -> write("mixed")
    }
    close()
}