//a, b 입력받고 각각 출력하기 - 문자열 안에 ${}를 통해 변수 출력하는 것이 포인트
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("a = ${a}\nb = ${b}")
}