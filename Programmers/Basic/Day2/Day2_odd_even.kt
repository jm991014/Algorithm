fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    if(a % 2 == 0) {
        print("$a is even")
    }else{
        print("$a is odd")
    }
}
// println("$num is ${if (num % 2 == 0) "even" else "odd"}")
// 위와 같이 람다식을 활용하는 것이 좋을 듯 함.