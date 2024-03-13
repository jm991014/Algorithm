fun main() {
    var arr = mutableListOf<Int>()
    repeat(10) {
        val input = readln().toInt()
        val remain = input % 42
        arr.add(remain)
    }
    print(arr.toSet().size)
}