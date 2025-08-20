class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        partition(s, 0, path);
        return ans;
    }

    private void partition(String s, int ind, List<String> path){
        int n = s.length();
        if(ind == n){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = ind; i<n; i++){
            if(isPalindrome(s, ind, i)){
                path.add(s.substring(ind, i+1));
                partition(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String S, int s, int e){
        while(s < e){
            if(S.charAt(s++) != S.charAt(e--)) return false;
        }
        return true;
    }
}