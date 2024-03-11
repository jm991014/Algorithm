fun main() {
    while(true) {
        readLine()?.let { input ->
            if(input.isNotBlank()) println(input)
        } ?: break
    }
}
