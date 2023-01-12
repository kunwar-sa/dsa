class Test {

        public static void main(String[] args) {

                // int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
                // int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
                // 15, 16 } };
                // int[][] arr = { { 2, 3 } };
                int[][] arr = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                                { 18, 21, 23, 26, 30 } };

                System.out.println(searchMatrix(arr, 100));

        }

        public static boolean searchMatrix(int[][] matrix, int target) {

                boolean ans = false;
                int row = matrix.length - 1;
                int col = matrix[0].length - 1;

                int y = row;
                int x = 0;

                while (x <= col && y >= 0) {

                        int current = matrix[y][x];
                        if (target == current) {
                                ans = true;
                                break;
                        }
                        if (target > current)
                                x++;
                        else
                                y--;
                }

                return ans;
        }

}
