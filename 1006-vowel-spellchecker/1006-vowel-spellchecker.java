import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> devowelMap = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            if (!lowerMap.containsKey(lower)) lowerMap.put(lower, word);

            String devow = devowel(lower);
            if (!devowelMap.containsKey(devow)) devowelMap.put(devow, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                result[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (lowerMap.containsKey(lower)) {
                    result[i] = lowerMap.get(lower);
                } else {
                    String devow = devowel(lower);
                    result[i] = devowelMap.getOrDefault(devow, "");
                }
            }
        }
        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('a');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}