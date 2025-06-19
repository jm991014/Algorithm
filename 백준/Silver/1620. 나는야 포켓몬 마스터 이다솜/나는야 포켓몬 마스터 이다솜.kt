private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (M, N) = br.readLine().split(" ").map { it.toInt() }
    val pokeDex1 = mutableListOf<String>()
    val pokeDex2 = mutableMapOf<String, Int>()

    repeat(M) {
        val pokemon = br.readLine()
        pokeDex1.add(pokemon)
        pokeDex2[pokemon] = it
    }

    repeat(N) {
        val toFind = br.readLine()
        if (toFind[0].isDigit()) write("${pokeDex1[toFind.toInt() - 1]}\n")
        else write("${pokeDex2[toFind]!! + 1}\n")
    }

    close()
}