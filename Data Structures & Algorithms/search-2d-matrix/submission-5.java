class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0; 
        int r = matrix.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int value = matrix[mid][0];
            if (value == target)    return true;
            if (value < target) l = mid + 1;
            if (value > target) r = mid - 1;
        }

        // Tìm được vị trí dòng phù hợp có thể chứa target.
        // Cập nhật lại vị trí của left và right trong row.
        if (r < 0)  return false;
        int[] row = matrix[r];
        r = row.length - 1;
        l = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int value = row[mid];
            if (value == target)    return true;
            if (value < target)  l = mid + 1;
            if (value > target) r = mid - 1;
        }
        return false;
    }
}
