fun main() {
    val input = readln().split(" ")
    var hour = input[0].toInt()
    var min = input[1].toInt()
    if((min - 45) < 0) {
        if(hour == 0) hour = 23 else hour -= 1
        min += 15
        print("$hour $min")
    } else {
        print("$hour ${min-45}")
    }
}