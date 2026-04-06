private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val N = br.readLine().toInt()

    val arr = Array(N) { CharArray(2 * N) { ' ' } }

    arr.draw(0, N - 1, N)

    for (i in 0 until N) {
        bw.write(arr[i], 0, 2 * N - 1)
        bw.write("\n")
    }

    bw.close()
}

fun Array<CharArray>.draw(r: Int, c: Int, size: Int) {
    if (size == 3) {
        this[r][c] = '*'
        this[r + 1][c - 1] = '*'
        this[r + 1][c + 1] = '*'
        for (i in -2..2) {
            this[r + 2][c + i] = '*'
        }
        return
    }

    val nextSize = size / 2

    draw(r, c, nextSize)
    draw(r + nextSize, c - nextSize, nextSize)
    draw(r + nextSize, c + nextSize, nextSize)
}