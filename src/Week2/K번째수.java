package Week2;

import java.util.*;

class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        while(index < commands.length){
            ArrayList<Integer> al = new ArrayList<>();
            int st = commands[index][0] - 1;
            int ed = commands[index][1] - 1;

            for(int i = st; i <= ed; i++){
                al.add(array[i]);
            }

            Collections.sort(al);

            answer[index] = al.get(commands[index][2] - 1);
            index++;
        }

        return answer;
    }
}

