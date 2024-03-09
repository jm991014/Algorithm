fun main() {
    val arr = MutableList<Int>(30, {i->i+1})
    repeat(28) {
        val input = readln().toInt()
        arr.remove(input)
    }
    arr.forEach { println(it) }
}