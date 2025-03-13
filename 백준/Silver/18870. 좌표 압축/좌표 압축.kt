private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val sortedNums = nums.distinct().sorted()
    nums.forEach {
        write("${sortedNums.binarySearch(it)} ")
    }
    close()
}