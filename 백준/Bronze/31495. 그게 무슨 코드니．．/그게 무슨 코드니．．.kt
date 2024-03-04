fun main() {    
    val input = readln()
    if(input.first() == '"' && input.last() == '"' && input.length > 2) {
        print(input.substring(1, input.length - 1))
    } else {
        print("CE")
    }
}