class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map1= new HashMap<>();
        for( char ch: s.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        String vow="aeiou";
        int cons=0;
        int vowel=0;
        for(char ch:map1.keySet()){
            if(vow.indexOf(ch)==-1){
                cons=Math.max(cons,map1.get(ch));
            }else{
                vowel=Math.max(vowel,map1.get(ch));
            }
        }
        return cons+vowel;
    }
}