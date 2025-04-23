private val br = System.`in`.bufferedReader()

private data class Body(var head: Pair<Int, Int>, var heart: Pair<Int, Int>, var lArm: Int, var rArm: Int, var waist: Int, var lLeg: Int, var rLeg: Int)

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val cookie = Array(N) { br.readLine().toCharArray() }
    val body = Body(-1 to -1, 0 to 0, 0, 0, 0, 0, 0)

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (body.head == -1 to -1 && cookie[i][j] == '*') {
                body.head = i to j
                body.heart = i + 1 to j
            }
            if (i == body.heart.first && j < body.heart.second && cookie[i][j] == '*') body.lArm++
            if (i == body.heart.first && j > body.heart.second && cookie[i][j] == '*') body.rArm++
            if (i > body.heart.first && j == body.heart.second && cookie[i][j] == '*') body.waist++
            if (i > body.heart.first + body.waist && j < body.heart.second && cookie[i][j] == '*') body.lLeg++
            if (i > body.heart.first + body.waist && j > body.heart.second && cookie[i][j] == '*') body.rLeg++
        }
    }
    write("${body.heart.first + 1} ${body.heart.second + 1}\n${body.lArm} ${body.rArm} ${body.waist} ${body.lLeg} ${body.rLeg}")
    close()
}