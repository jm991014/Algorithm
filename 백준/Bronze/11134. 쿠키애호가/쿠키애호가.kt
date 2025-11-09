private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val (N, C) = br.readLine().split(" ").map { it.toInt() }

        if (N % C == 0) write("${N / C}\n") else write("${N / C + 1}\n")
    }
    close()
}