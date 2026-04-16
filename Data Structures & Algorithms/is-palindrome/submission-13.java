class Solution {
    private boolean isAlphanumeric(char c) {
        return (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 48 && c <= 57);
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] arr = s.toLowerCase().toCharArray();
        while (l <= r) {
            while (l <= r && !isAlphanumeric(arr[l])) l++;
            while (r >= 0 && !isAlphanumeric(arr[r])) r--;
            if (l <= r && arr[l] == arr[r])   {
                l++;
                r--;
            }   else if (l <= r)    return false;
        }
        return true;
    }
}
