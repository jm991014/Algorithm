private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val name = br.readLine()
    val teams = Array(br.readLine().toInt()) { br.readLine() }.sorted()
    var maxScore = -1
    var maxTeam = ""

    teams.forEach {
        val tmp = name + it
        val L = tmp.count { it == 'L' }
        val O = tmp.count { it == 'O' }
        val V = tmp.count { it == 'V' }
        val E = tmp.count { it == 'E' }
        val score = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100
        if (score > maxScore) {
            maxScore = score
            maxTeam = it
        }
    }
    println(maxTeam)
}