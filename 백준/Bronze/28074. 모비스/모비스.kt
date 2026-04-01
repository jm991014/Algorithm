private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    if (br.readLine().toSet().containsAll(setOf('M', 'O', 'B', 'I', 'S'))) bw.write("YES") else bw.write("NO")
    bw.close()
}