private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map(String::toInt).sorted().toIntArray()
    val x = br.readLine().toInt()
    var cnt = 0
    var s = 0
    var e = n - 1

    while (s < e) {
        when {
            nums[s] + nums[e] == x -> {
                cnt++
                s++
            }
            nums[s] + nums[e] > x -> e--
            nums[s] + nums[e] < x -> s++
        }
    }
    println(cnt)
}
