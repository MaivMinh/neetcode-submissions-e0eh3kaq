class Solution {
    private HashMap<Character, Integer> prepareMap(String input) {
        HashMap<Character, Integer> map = new HashMap();
        if (input == null || input.length() == 0)   return map;
        for (Character c: input.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1); 
            }   else map.put(c, 1);
        }
        return map;
    }

    private boolean checkAnagram(HashMap<Character, Integer> map, String input) {
        if (map.isEmpty() && input.length() != 0)   return false;
        if (map.isEmpty() && input.length() == 0)   return true;
        for (Character c: input.toCharArray()) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                if (count == 1) {
                    map.remove(c);
                }   else if (count > 1) {
                    map.put(c, count - 1);
                }
            }   else return false;
        }
        return map.isEmpty();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] used = new boolean[strs.length];
        List<List<String>> result = new ArrayList();
        for (int i = 0; i < strs.length; i++) {
            if (!used[i])   {
                List<String> list = new ArrayList();
                list.add(strs[i]);
                used[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    if (!used[j]) {
                        HashMap<Character, Integer> map = null;
                        map = prepareMap(strs[i]);   /// pass by value.
                        boolean isAnagram = checkAnagram(map, strs[j]);
                        if (isAnagram) {
                            list.add(strs[j]);
                            used[j] = true;
                        }
                    }
                }
                result.add(list);
            }
        }
        return result;
    }
}
