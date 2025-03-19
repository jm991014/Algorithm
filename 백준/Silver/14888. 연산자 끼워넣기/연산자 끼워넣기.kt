import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val equations = mutableListOf<String>()
private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val operands = br.readLine().split(" ").map { it.toInt() }
    val operators = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    getCombination(N, operators,"")

    equations.forEach {
        val result = calculate(operands, it)
        max = max.coerceAtLeast(result)
        min = min.coerceAtMost(result)
    }
    write("$max\n$min")
    close()
}

fun getCombination(N: Int, operators: IntArray, equation: String) {
    if (equation.length == N - 1) {
        equations.add(equation)
        return
    }
    operators.forEachIndexed { idx, operator ->
        if (operator != 0) {
            operators[idx] -= 1
            getCombination(N, operators, equation + idx)
            operators[idx] += 1
        }
    }
}

fun calculate(operands: List<Int>, combination: String): Int {
    val queue = LinkedList(operands)
    val equation = mutableListOf<Int>()
    var count = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        equation.add(cur)
        if (equation.size == 2) {
            val result = when(combination[count]) {
                '0' -> equation[0] + equation[1]
                '1' -> equation[0] - equation[1]
                '2' -> equation[0] * equation[1]
                else -> equation[0] / equation[1]
            }
            count++
            equation.clear()
            equation.add(result)
        }
    }
    return equation[0]
}