private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val countries = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    countries.find { it[0] == K }?.let { target ->
        val rank = countries.count { country ->
            if (country[1] > target[1]) true
            else if (country[1] == target[1] && country[2] > target[2]) true
            else country[1] == target[1] && country[2] == target[2] && country[3] > target[3]
        }

        bw.write("${rank + 1}")
    }
    bw.close()
}