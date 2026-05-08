class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)    return s.length();
        int n = s.length();
        int l = 0;
        int r = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(l), l);
        int max = 1;
        while (r < n) { // O(N).
            Character c = s.charAt(r);
            if (map.containsKey(c)) {
                /// Da co.
                max = Math.max(max, r - l);
                Integer index = map.get(c);
                index++;    /// posible index for left pointer.
                l = Math.max(l, index);
                map.put(c, r);
            }   else {
                map.put(c, r);
            }
            r ++;
        }
        return Math.max(max, r - l);
    }
}