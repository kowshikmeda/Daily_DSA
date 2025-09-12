class Solution {
    // Helper to check if character is a vowel (only lowercase needed here)
    private boolean checkVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || 
                ch == 'o' || ch == 'u');
    }

    public boolean doesAliceWin(String s) {
        int vowels = 0;

        // Count total vowels in the string
        for (char ch : s.toCharArray()) {
            if (checkVowel(ch)) {
                vowels++;
            }
        }

        // Alice wins if and only if there's at least one vowel
        return (vowels > 0);
    }
}