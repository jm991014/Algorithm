class Solution {
    fun solution(id_pw: Array<String>, db: Array<Array<String>>): String = when {
        db.any { it.contentEquals(id_pw) } -> "login"
        db.any { it.contains(id_pw[0]) } -> "wrong pw"
        else -> "fail"
    }
}