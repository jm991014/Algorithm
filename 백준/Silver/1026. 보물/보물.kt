private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val arr1 = br.readLine().split(" ").map { it.toInt() }.sortedDescending()
    val arr2 = br.readLine().split(" ").map { it.toInt() }.sorted()
    write("${arr1.zip(arr2) { a, b -> b * a }.sum()}")
    close()
}