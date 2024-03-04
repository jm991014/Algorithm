fun main() {    
    val input = readln().trim()
    var blank = 1
    if(input.length == 0) print("0")
    else {
        for(i in 0 until input.length) {
            if(input[i] == ' ') blank += 1
        }
        print(blank)
    }
    
}