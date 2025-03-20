import java.util.LinkedList

class Solution {   
    fun solution(tickets: Array<Array<String>>): Array<String> = dfs(tickets.sortedBy { it[1] }, BooleanArray(tickets.size), mutableListOf("ICN")).toTypedArray()
    
    fun dfs(tickets: List<Array<String>>, visited: BooleanArray, route: MutableList<String>): MutableList<String> {
        if (route.size == tickets.size + 1) return route
        val current = route.last()
        for (i in tickets.indices) {
            if (tickets[i][0] == current && !visited[i]) {
                visited[i] = true
                route.add(tickets[i][1])
                val result = dfs(tickets, visited, route)
                if (result.size == tickets.size + 1) return result
                visited[i] = false
                route.removeAt(route.size - 1)
            }
        }
        return route
    }
}