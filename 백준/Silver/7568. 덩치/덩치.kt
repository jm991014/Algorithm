private val br =  System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val body = Array(N) { br.readLine().split(" ").map { it.toInt() }.let { it[0] to it[1] } }

    body.forEach { (weightA, heightA) ->
        var rank = 1
        body.forEach { (weightB, heightB) ->
            if (heightB > heightA && weightB > weightA) rank++
        }
        write("$rank ")
    }
    close()
}
