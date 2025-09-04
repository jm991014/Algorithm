private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    while (true) {
        val key = br.readLine()
        if (key == "0") break

        val text = br.readLine()
        val cipherText = StringBuilder()

        for (i in text.indices) {
            val char = text[i]
            val keyChar = key[i % key.length]
            val shiftPosition = ((char - 'A') + (keyChar - 'A' + 1)) % 26
            cipherText.append((shiftPosition + 'A'.code).toChar())
        }
        write("$cipherText\n")
    }
    close()
}
