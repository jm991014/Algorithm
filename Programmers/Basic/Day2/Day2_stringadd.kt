// 입력받은 두 문자를 붙여서 출력하기
fun main(args: Array<String>) {
    val input = readLine()!!.split(' ')
    val s1 = input[0]
    val s2 = input[1]
    val s3 = "${s1+s2}"
    print(s3)
}
// add.kt와 마찬가지로 $로 변수를 그대로 사용하고, +로 두 String을 붙여준다.