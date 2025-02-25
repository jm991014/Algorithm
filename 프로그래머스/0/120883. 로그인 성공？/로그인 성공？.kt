class Solution {
    fun solution(id_pw: Array<String>, db: Array<Array<String>>): String = when {
        db.any { it[0] == id_pw[0] && it[1] == id_pw[1] } -> "login"
        db.any { it.contains(id_pw[0]) } -> "wrong pw"
        else -> "fail"
    }
}