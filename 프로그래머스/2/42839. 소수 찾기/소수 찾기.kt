import kotlin.math.sqrt

class Solution {
    val numSet = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        getPermutations(numbers, "")
        return isPrimeNum(numSet)
    }
    
    fun getPermutations(numbers: String, result: String) { 
        if(result.isNotEmpty()) numSet.add(result.toInt()) 
        if(numbers.isEmpty()) return
        
        numbers.forEachIndexed { index, c ->
            getPermutations(numbers.removeRange(index..index), c.plus(result))
        }
    }
    
    fun isPrimeNum(numSet: Set<Int>): Int {
        val maxNum = numSet.maxOrNull() ?: return 0
        val sieve = BooleanArray(maxNum + 1) { true }
        sieve[0] = false
        sieve[1] = false
        for(i in 2 .. sqrt(maxNum.toDouble()).toInt()) {
            if (sieve[i]) {
                for (j in i * i..maxNum step i) {
                    sieve[j] = false
                }
            }
        }
        
        return numSet.count { sieve[it] }   
    }
}