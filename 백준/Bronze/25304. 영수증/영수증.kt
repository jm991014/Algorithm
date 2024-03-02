fun main() {    
    var sum = readln().toInt()
    var item = readln().toInt()
    for(i in 1..item) {
        val input = readln().split(" ").map { it.toInt() }
        sum -= input[0] * input[1]
    }
    if(sum == 0) print("Yes") else print("No")
}