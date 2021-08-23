package Week1;

// 출처 : https://programmers.co.kr/learn/challenges

import java.util.*;

class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int lotpoint = 0;
        int winpoint = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int zero_cnt = 0;
        int cnt = 0;

        for(int i = 0; i < 6; i++){
            int value = Arrays.binarySearch(win_nums, lottos[i]);
            if(value >= 0) cnt++;
            if(lottos[i] == 0) zero_cnt++;
        }
        int result[] = new int[2];
        result[0] = getScore(cnt + zero_cnt);
        result[1] = getScore(cnt);
        return result;
    }
    static int getScore(int result){
        switch(result){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
    /*
    import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int lotpoint = 0;
        int winpoint = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int zero_cnt = 0;
        int cnt = 0;

        for(int i = 0; i < 6; i++){
            int value = binarySearch(lottos[i], win_nums);
            if(value == 1) cnt++;
            if(lottos[i] == 0) zero_cnt++;
        }
        int result[] = new int[2];
        result[0] = getScore(cnt + zero_cnt);
        result[1] = getScore(cnt);
        return result;
    }
    static int getScore(int result){
        switch(result){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
    static int binarySearch(int target, int[] win_nums){
        int start = 0;
        int end = win_nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(win_nums[mid] == target)
                return 1;
            else{
                if(target < win_nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return 0;
    }
}

     */
}
