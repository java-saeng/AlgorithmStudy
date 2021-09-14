package Week10;

class 모음사전 {
    static String s[] = {"A", "E", "I", "O", "U"};
    static int max;
    static boolean flag = false;
    public int solution(String word) {
        String st = "" + word.charAt(0);
        int answer = 0;
        dfs(st, 1, word);

        for(int i = 0; i < 5; i++){
            if(st.equals(s[i])){
                dfs(st, 1, word);
                answer = 781 * i + max;
            }
        }

        return answer;
    }
    static void dfs(String str, int cnt, String word){
        if(cnt >= 6) return;
        if(flag) return;
        max++;

        if(word.equals(str)) {
            flag = true;
            return;
        }
        for(int i = 0; i < 5; i++){
            dfs(str + s[i], cnt + 1, word);
        }
    }
}
