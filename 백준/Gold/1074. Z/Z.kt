private val br = System.`in`.bufferedReader()

var ans = 0
var index = 0

fun main() = with(System.out.bufferedWriter()) {
    val (N, r, c) = br.readLine().split(" ").map { it.toInt() }

    findZ(1 shl(N), 0, 0, r, c)
    write("$ans")
    close()
}

fun findZ(s: Int, r: Int, c: Int, tr: Int, tc: Int) {
    if (tr !in r until r + s || tc !in c until c + s) {
        index += s * s
        return
    }

    if (tr == r && tc == c) {
        ans = index
        return
    }

    val half = s / 2

    findZ(half, r, c, tr, tc)
    findZ(half, r, c + half, tr, tc)
    findZ(half, r + half, c, tr, tc)
    findZ(half, r + half, c + half, tr, tc)
}