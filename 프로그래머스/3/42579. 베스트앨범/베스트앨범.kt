class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var genresHashMap = HashMap<String, MutableList<Pair<Int, Int>>>()

        genres.forEachIndexed { index, genre ->
            if(genre in genresHashMap) genresHashMap[genre]!!.add(Pair(plays[index], index))
            else genresHashMap[genre] = mutableListOf(Pair(plays[index], index))
        }

        val genresList = genresHashMap
        	.toList()
        	.sortedByDescending { it.second.sumOf { it.first } }
        	.map { it.second.sortedByDescending { it.first }.take(2).map { it.second } }
        	.flatten()
            
        return genresList.toIntArray()
    }
}