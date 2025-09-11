class Solution {
    public String sortVowels(String s) {
      ArrayList<Character> vowel=new ArrayList<>();
      String vowels="AEIOUaeiou";
      StringBuilder res=new StringBuilder();
      //storing vowels in arraylist
      for(char ch:s.toCharArray()){
        if(vowels.indexOf(ch)!=-1){
            vowel.add(ch);
        }
      }
      //sorting them via sort()
      Collections.sort(vowel);
      //creating index for vowel
      int index=0;
      for(char ch:s.toCharArray()){
        if(vowels.indexOf(ch)!=-1){
            res.append(vowel.get(index++));
        }else{
            res.append(ch);
        }
      }
      return res.toString();
    }
}