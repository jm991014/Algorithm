import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        return myString.chars()
            .map(c -> c < 'l' ? 'l' : c)
            .mapToObj(c -> String.valueOf((char)c))
            .collect(Collectors.joining());
    }
}