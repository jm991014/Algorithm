class Solution {
    fun solution(slice: Int, n: Int) = if (n % slice == 0) n / slice else (n / slice) + 1
}