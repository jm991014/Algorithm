class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val ans = IntArray(2)
        for(i in nums.indices) {
            for(j in i + 1..nums.size - 1) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i
                    ans[1] = j
                }
            }
        }
        return ans
    }
}