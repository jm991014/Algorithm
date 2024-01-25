// 입력받은 문자열을 90도 돌려서 출력하기
fun main(args: Array<String>) {
    val s1 = readLine()!!
    val s2 = s1.toMutableList()
    for(i in s2.indices) {
        println(s2[i])
    }
}