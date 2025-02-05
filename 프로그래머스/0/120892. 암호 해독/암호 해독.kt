class Solution {
    fun solution(cipher: String, code: Int): String = cipher.filterIndexed { idx, _ -> (idx + 1) % code == 0 }
}