private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    var str = br.readLine()
    val target = br.readLine()
    val sb = StringBuilder()

    for (char in str) {
        sb.append(char)

        if (sb.length >= target.length) {
            var isMatch = true

            for (i in target.indices) {
                if (sb[sb.length - target.length + i] != target[i]) {
                    isMatch = false
                    break
                }
            }

            if (isMatch) sb.delete(sb.length - target.length, sb.length)
        }
    }
    
    val result = sb.toString()
    bw.write(result.ifEmpty { "FRULA" })
    bw.close()
}
