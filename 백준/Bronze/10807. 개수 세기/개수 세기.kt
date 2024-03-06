fun main() {    
    val num = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val target = readln().toInt()
    var result = 0
    for(i in 0 until num) {
        if(numbers[i] == target) result += 1
    }
    print(result)
}