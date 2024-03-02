fun main() {    
    val input = readln().toInt()
    repeat(input) {
        val case = readln().split(" ").map { it.toInt() }
        val a = case[0]
        val b = case[1]
        println(a + b)
    }
}