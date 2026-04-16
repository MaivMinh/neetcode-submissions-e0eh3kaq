class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = 0;
            for (int j = i + 1; j < nums.length -1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0)   {
                        /// check existed.
                        String str = nums[i] + "." + nums[j] + "." + nums[k];
                        if (!set.contains(str)) {
                            List<Integer> arr = new ArrayList<>();
                            arr.add(nums[i]);
                            arr.add(nums[j]);
                            arr.add(nums[k]);
                            result.add(arr);
                            set.add(str);
                        }
                    }
                }
            }
        }

        return result;
    }
}
