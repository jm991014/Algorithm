class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        for(i in strArr.indices) {
            if(strArr[i].contains("ad"))
            else answer += strArr[i]
        }
        return answer
    }
}