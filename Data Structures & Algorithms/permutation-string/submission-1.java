class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] win = new int[26];

        for (char c: s1.toCharArray()) {
            need[c - 'a']++;
        }

        int size = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            win[c - 'a']++;
            if (i >= size)  {
                win[s2.charAt(i - size) - 'a']--;
            }

            if (matches(need, win)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] need, int[] win)  {
        for (int i = 0; i < 26; i++) {
            if (need[i] != win[i])  return false;
        }

        return true;
    }
}
