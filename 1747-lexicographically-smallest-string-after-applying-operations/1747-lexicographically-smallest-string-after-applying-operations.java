class Solution {
    private String res;
    private Set<String> se;

    public String findLexSmallestString(String s, int a, int b) {
        this.res = s;
        se = new HashSet<>();
        dfs(s, a, b);

        return res;
    }

    private void dfs(String s, int a, int b){
        if(!se.contains(s)){
            int n = s.length();
            se.add(s);
            if(this.res.compareTo(s) > 0) this.res = s;

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                if(i % 2 == 1){
                    sb.append((char) ('0' + ((s.charAt(i) - '0' + a) % 10)));
                }
                else sb.append(s.charAt(i));
            }

            dfs(new String(sb), a, b);

            String rotated = s.substring(n - b) + s.substring(0, n - b);

            dfs(rotated, a, b);
        }
    }
}