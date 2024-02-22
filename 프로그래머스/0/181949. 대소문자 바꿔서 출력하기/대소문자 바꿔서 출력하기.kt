fun main(args: Array<String>) {
    val s1 = readLine()!!
    val s2 = s1.toMutableList()
    for(i in s2.indices) {
        if(s2[i].isUpperCase()){
            s2[i] = s2[i].lowercaseChar()
        }else{
            s2[i] = s2[i].uppercaseChar()
        }
    }
    val s3 = s2.joinToString("")
    print(s3)
}