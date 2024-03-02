fun main() {
    val input = readln().split(" ")
    var hour = input[0].toInt()
    var min = input[1].toInt()
    val time = readln().toInt()
    if(min + time >= 60) {
        hour += (min + time) / 60
        if(hour >= 24) hour -= 24
        min = (min + time) % 60
        print("$hour $min")

    } else {
        print("$hour ${min+time}")
    }
}
