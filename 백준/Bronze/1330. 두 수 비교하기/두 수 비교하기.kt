fun main() {
    val input = readLine()!!.split(" ")
    val a = input[0].toInt()
    val b = input[1].toInt()
    if(a > b) print(">")
    else if(a < b) print("<")
    else print("==")
}