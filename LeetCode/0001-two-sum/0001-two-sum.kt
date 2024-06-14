class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for(i in nums.indices) {
            for(j in i + 1..nums.size - 1) {
                if(nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        throw IllegalArgumentException("no answer")
    }
}