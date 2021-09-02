package Week9;

class 단체사진찍기 {
    static char ch[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean visit[] = new boolean[8];
    static String str[] = new String[8];
    static int ans = 0;
    public int solution(int n, String[] data) {

        ans = 0;

        dfs(0, data);

        return ans;
    }

    static void dfs(int cnt, String[] data){
        if(cnt == 8){
            String s = "";

            for(int i = 0; i < 8; i++){
                s += str[i];
            }

            if(data(s,data)) ans++;

            return;
        }

        for(int i = 0; i < 8; i++){
            if(visit[i]) continue;

            visit[i] = true;
            str[cnt] = "" + ch[i];
            dfs(cnt+1, data);
            visit[i] = false;
        }
    }
    static boolean data(String s, String datas[]){
        for(String data : datas){
            int index1 = s.indexOf(data.charAt(0));
            char sec = data.charAt(2);
            char op = data.charAt(3);
            int cond = data.charAt(4) - '0';

            int index2 = 0;

            index2 = s.indexOf("" + sec);

            int diff = Math.abs(index1 - index2) - 1;

            switch(op){
                case '=':
                    if(diff != cond)
                        return false;
                    break;
                case '>':
                    if(!(diff > cond))
                        return false;
                    break;
                case '<':
                    if(!(diff < cond))
                        return false;
                    break;
            }
        }
        return true;
    }
}