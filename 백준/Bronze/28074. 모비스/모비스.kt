private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    br.readLine().let { str -> if ("MOBIS".all { it in str }) bw.write("YES") else bw.write("NO") }
    bw.close()
}