class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 1;
        for (int pile: piles) {
            max = Math.max(max, pile);
        }

        int mid = 1;
        while (min <= max) {
            mid = min + (max - min) / 2;
            int hours = 0;
            for (int pile: piles) {
                hours += Math.ceil((double) pile / mid);
            }

            if (hours > h) {
                min = mid + 1;
            }   else max = mid - 1;
        }

        return min;
    }
}
