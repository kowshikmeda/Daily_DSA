class Solution {
    HashSet<String> visited = new HashSet<>();
    HashMap<String, List<String>> map = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed){
            if (!map.containsKey(s.substring(0,2))) map.put(s.substring(0,2), new ArrayList<>());
            map.get(s.substring(0,2)).add(s.substring(2));
        }
        return helper(bottom);
    }
    private boolean helper(String bottom){
        if (bottom.length() == 1) return true;
        if (visited.contains(bottom)) return false;
        visited.add(bottom);
        HashSet<String> lastRound = new HashSet<>();
        lastRound.add("");
        for (int i = 0; i < bottom.length()-1; i++){
            if (!map.containsKey(bottom.substring(i,i+2))) return false;
            List<String> candidate = map.get(bottom.substring(i,i+2));
            HashSet<String> nextRound = new HashSet<>();
            for (String last : lastRound){
                for (String c : candidate){
                    nextRound.add(last+c);
                }                
            }
            lastRound = nextRound;
        }
        for (String s : lastRound){
            if (helper(s)) return true;
        }
        return false;
    }
}