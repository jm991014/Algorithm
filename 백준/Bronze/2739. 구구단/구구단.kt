fun main() {
    val input = readLine()!!.toInt()
    for(i in 1..9) {
        var mul = input * i
        println("$input * $i = $mul")
    }
}