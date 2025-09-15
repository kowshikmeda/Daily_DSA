class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> hs = new HashSet<>();
        for (char a : brokenLetters.toCharArray()) {
            hs.add(a);
        }
        int res = 0;
        for (String w : text.split(" ")) {
            boolean broken = false;
            for (char a1 : w.toCharArray()) {
                if (hs.contains(a1)) {
                    broken = true;
                    break;
                }
            }
            if (!broken)
            res++;
        }


        return res;
    }
}