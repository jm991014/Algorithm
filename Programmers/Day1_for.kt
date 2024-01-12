//for문 기초 - 1..a 대신 until을 사용하게 되면 -1 길이까지
//변수 선언 없이 사용하려면 for(i: Int in 1..10)와 같이 사용하면 됨 - 파이썬이랑 비슷한듯
fun main(args: Array<String>) {
	val input = readLine()!!.split(' ')
    val s1 = input[0]
    val a = input[1]!!.toInt()
    for(i in 1..a) {
        print(s1)
    }
}