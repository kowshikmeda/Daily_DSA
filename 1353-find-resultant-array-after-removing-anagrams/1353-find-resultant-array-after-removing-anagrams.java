class Solution {
    public List<String> removeAnagrams(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            HashMap<Character,Integer> copyMap = new HashMap<>();
            for(int j=0;j<word.length();j++){
                 char ch = word.charAt(j); 
                if (copyMap.containsKey(ch)) {
                    copyMap.put(ch, copyMap.get(ch) + 1);
                } else {
                    copyMap.put(ch, 1);
                }
            }
            if(!map.equals(copyMap)){
                list.add(word);
                map = copyMap;
            }
        }
        return list;
    }
}