class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        val network = Array(n + 1) { IntArray(n + 1) }
    
        var answer = 0
        
        computers.forEachIndexed { index, computer ->
            for(i in 0 until n) {
                network[index + 1][i + 1] = computer[i]
            }
        }

        network.forEach { net ->
            net.forEach {
                print(it)
            }
        }
        // dfs
        
        
        return answer
    }
}