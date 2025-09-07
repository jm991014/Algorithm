private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val nums = br.readLine().split(" ").map(String::toInt)

    write("${(nums[2] * nums[4] - nums[1] * nums[5]) / (nums[0] * nums[4] - nums[1] * nums[3])} ${(nums[0] * nums[5] - nums[3] * nums[2]) / (nums[0] * nums[4] - nums[1] * nums[3])}")
    close()
}
