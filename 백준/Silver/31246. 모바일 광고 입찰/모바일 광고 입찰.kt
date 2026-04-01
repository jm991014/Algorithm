private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, K) = br.readLine().split(" ").map(String::toInt)
    val ads = LongArray(N)

    repeat(N) {
        val (A, B) = br.readLine().split(" ").map(String::toLong)
        ads[it] = A - B
    }

    ads.sorted()[N - K].let {
        if (it >= 0) bw.write("0") else bw.write("${-it}")
    }
    
    bw.close()
}