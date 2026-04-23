class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int min = 1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (int) Math.ceil((double) pile / mid);
            }

            if (hours > h) {
                min = mid + 1;
            } else
                max = mid - 1;
        }

        return min;
    }
}
