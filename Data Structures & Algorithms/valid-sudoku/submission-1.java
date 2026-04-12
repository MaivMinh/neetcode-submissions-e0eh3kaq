class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> rowMap = new HashMap<>();
        Map<Integer, HashSet<Character>> colMap = new HashMap<>();
        Map<String, HashSet<Character>> boxMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)   {
                if (board[i][j] == '.') continue;
                /// Check trong row map.
                HashSet<Character> rowSet = rowMap.get(i);
                if (rowSet != null && rowSet.contains(board[i][j]))   return false;
                else if (rowSet == null) {
                    rowSet = new HashSet<>();
                    rowMap.put(i, rowSet);
                }

                /// Check trong row column.
                HashSet<Character> colSet = colMap.get(j);
                if (colSet != null && colSet.contains(board[i][j]))   return false;
                else if (colSet == null) {
                    colSet = new HashSet<>();
                    colMap.put(j, colSet);
                }

                /// Check trong sub-box.
                int row = i / 3;
                int col = j / 3;
                String key = new String(row + "." + col);
                HashSet<Character> boxSet = boxMap.get(key);
                if (boxSet != null && boxSet.contains(board[i][j]))   return false;
                else if (boxSet == null) {
                    boxSet = new HashSet<>();
                    boxMap.put(key, boxSet);
                }

                /// Lưu ý: Với mõi new HashSet<>() được tạo mới thì phải 
                /// thực hiện put lại vào Map, vì nếu trong trường hợp này
                /// Set mới chưa tồn tại (reference) trong map đâu.
                /// Nếu không thực hiện map thì Set sẽ luôn rỗng khi duyệt
                /// qua các cell và điều này làm cho kết quả sẽ luôn return true.

                /// Thêm vào row, col, sub-box.
                rowSet.add(board[i][j]);
                colSet.add(board[i][j]);
                boxSet.add(board[i][j]);
            }
        }

        return true;
    }
}
