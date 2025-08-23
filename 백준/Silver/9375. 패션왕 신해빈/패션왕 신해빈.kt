private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val clothes = HashMap<String, Int>(n)
        repeat(n) {
            val (_, key) = br.readLine().trim().split(' ')
            clothes[key] = clothes.getOrDefault(key, 0) + 1
        }
        var combination = 1
        clothes.values.forEach {
            combination *= it + 1
        }
        write("${combination - 1}\n")
    }
    close()
}
