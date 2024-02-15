class Solution {
    fun solution(num_list: IntArray): IntArray {
        val list = ArrayList<Int>()
        val size: Int = num_list.size
        for(i in num_list.indices) {
            list.add(num_list[i])
        }
        if(num_list[size-1] > num_list[size-2]) {
            list.add(num_list[size-1] - num_list[size-2])
        } else {
            list.add(num_list[size-1] * 2)
        }
        return list.toIntArray()
    }
}
// takelast와 tomutablelist에 대해 공부
// val answer = num_list.toMutableList().apply {
//             val (first, second) = num_list.takeLast(2)
//             if (first < second) add(second - first)
//             else add(second + second)
//         }
//         return answer.toIntArray()    

// or 이러면 뒤에 추가가 되는듯
// return num_list + if (last > second) last - second else last * 2

fun main() {
    print(Solution().solution(intArrayOf(5, 2, 1, 7, 5)))
}