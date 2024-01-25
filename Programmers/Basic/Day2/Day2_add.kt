// 입력받은 두 숫자를 a + b = c와 같은 형식으로 출력하기
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    print("$a + $b = ${a+b}")
}
// Kotlin에서 작은 따옴표는 Char, 큰 따옴표는 String에 사용한다. 파이썬이랑 헷갈리지 말자
// $를 붙이면 그대로 출력, 두 개 이상 넣고 싶을 때는 중괄호를 사용하자