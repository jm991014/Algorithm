import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int sum = Arrays.stream(number).sum();

        Map<String, Integer> wantMap = new HashMap<>();
        for (int k = 0; k < want.length; k++) {
            wantMap.put(want[k], number[k]);
        }

        for (int i = 0; i <= discount.length - sum; i++) {
            String[] currentWindow = Arrays.copyOfRange(discount, i, i + sum);

            Map<String, Long> currentWindowMap = Arrays.stream(currentWindow)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            boolean canJoin = true;

            for (Map.Entry<String, Integer> entry : wantMap.entrySet()) {
                String wantedItem = entry.getKey();
                int wantedCount = entry.getValue();

                long currentCount = currentWindowMap.getOrDefault(wantedItem, 0L);

                if (wantedCount != currentCount) {
                    canJoin = false;
                    break;
                }
            }

            if (wantMap.size() != currentWindowMap.size()){
                canJoin = false;
            }

            if (canJoin) {
                answer++;
            }
        }
        return answer;
    }
}