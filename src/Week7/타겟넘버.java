package Week7;

import java.util.*;

class 타겟넘버 {
    static int count;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return count;
    }
    static void dfs(int[] numbers, int target, int sum, int cnt){
        if(cnt == numbers.length){
            if(sum == target)
                count++;
            return;
        }
        int s1 = sum + numbers[cnt];
        int s2 = sum - numbers[cnt];

        dfs(numbers, target, s1, cnt + 1);
        dfs(numbers, target, s2, cnt + 1);
    }
}
