class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int[] window = new int[26];

        for(char c: s1.toCharArray()) {
            freq[c - 'a'] ++;
        }

        int size = s1.length();
        /// maintain fixed window.
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            window[c - 'a']++;

            if (i >= size)  window[s2.charAt(i - size) - 'a'] --;
            if (matches(freq, window))  return true;
        }        

        return false;
    }

    private boolean matches(int[] freq, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != window[i])   return false;   
        }
        return true;
    }
}
