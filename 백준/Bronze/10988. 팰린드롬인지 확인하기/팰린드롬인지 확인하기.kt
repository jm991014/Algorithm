fun main() {
    val input = readln()
    var bool = 1
    for(i in 0..input.length/2) {
        if(input[i] == input[input.length-1-i])
        else{bool = 0}
    }
    print(bool)
}