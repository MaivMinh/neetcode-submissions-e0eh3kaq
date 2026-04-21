class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        /// col 0: position[i].
        /// col 1: time reach to target.
        for (int i = 0; i < n; i++) {
            double time = (double)(target - position[i]) / speed[i];
            cars[i][0] = position[i];
            cars[i][1] = time;
        }

        Arrays.sort(cars, (a, b) -> {
            return Double.compare(b[0], a[0]);
        });

        double prevTime = 0;
        int fleets = 0;
        for (double[] arr: cars) {
            if (arr[1] > prevTime) {
                fleets++;
                prevTime = arr[1];
            }
        }
        return fleets;
    }
}
