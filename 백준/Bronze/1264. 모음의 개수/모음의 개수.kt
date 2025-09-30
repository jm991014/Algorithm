private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val vowels = arrayOf('a', 'e', 'i', 'o', 'u')

    while (true) {
        val s = br.readLine().lowercase()
        if (s == "#") break

        write("${s.count { it in vowels }}\n")
    }
    close()
}