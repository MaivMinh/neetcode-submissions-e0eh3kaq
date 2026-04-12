class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefixProducts = new int[length];
        int[] suffixProducts = new int[length];
        prefixProducts[0] = 1;
        suffixProducts[length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixProducts[i] = nums[i-1] * prefixProducts[i-1];
        }

        for (int i = length - 2; i >= 0; i--) {
            suffixProducts[i] = nums[i+1] * suffixProducts[i+1];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }

        return result;
    }
}  
