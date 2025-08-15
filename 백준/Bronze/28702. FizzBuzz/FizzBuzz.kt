private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val fizzbuzz = Array(3) { br.readLine() }
    var target = 0

    fizzbuzz.forEachIndexed { index, s ->
        s.toIntOrNull()?.let {
            target = it + (4 - (index + 1))
        }
    }
    write(getFizzBuzz(target))
    close()
}

fun getFizzBuzz(num: Int) = when {
    num % 3 == 0 && num % 5 == 0 -> "FizzBuzz"
    num % 3 == 0 -> "Fizz"
    num % 5 == 0 -> "Buzz"
    else -> "$num"
}