class Solution {
    fun solution(s: String) = s.split(" ").fold((mutableListOf<Int>())) { total, num ->
        if (num == "Z") total.removeAt(total.lastIndex) else total.add(num.toInt())
        total
    }.sum()
}