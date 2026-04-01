private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        val N = br.readLine().toInt()
        bw.write(if ((N + 1) % (N % 100) == 0) "Good\n" else "Bye\n")
    }
    bw.close()
}