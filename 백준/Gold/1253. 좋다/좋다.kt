private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    var good = 0

    for (i in nums.indices) {
        var start = 0
        var end = N - 1
        while (start < end) {
            if (nums[start] + nums[end] == nums[i]) {
                if (start != i && end != i) {
                    good++
                    break
                }
                else if (start == i) start++
                else if (end == i) end--
            } else {
                if (nums[start] + nums[end] < nums[i]) start++ else end--
            }
        }
    }
    write("$good")
    close()
}