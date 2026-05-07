class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)    return 0;
        int l = 0;
        int r = 0;
        int size = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(r), r);
        r++;
        int max = 1;
        while (r < size) {
            Character c = s.charAt(r);
            if (map.containsKey(c)) {
                max = Math.max(max, (r - l));
                Integer value = map.get(c);
                value++;
                l = Math.max(value, l);
                map.remove(c);
                map.put(c, r);
                System.out.println(c + " " + r + " " + l + " if");
            }   else {
                map.put(c, r);
                System.out.println(c + " " + r + " " + l + " else");
            }
            r++;
        }
        max = Math.max(max, (size - l));
        return max;
    }
}
