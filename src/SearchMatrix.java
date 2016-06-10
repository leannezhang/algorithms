package src;

/**
 * Created by liyangzhang on 2016-06-10.
 */
public class SearchMatrix {

    public static int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // binary search each row
        // if found return 1 otherwise keep searching until reach the last row
        // row = i , column = j
        int start = 0;
        for (int i=0; i < matrix.size(); i++) {
            int present = binarySearch(matrix.get(i), target, start, matrix.get(i).size()-1);
            if (present == 1) {
                return 1;
            }
        }
        return 0;
    }

    public static int binarySearch(ArrayList<Integer> row, int target, int start, int end) {
        int mid = ((start + end ) / 2);
        if (end < start) {
            return 0;
        }
        if (target == row.get(mid)) {
            return 1;
        } else if ( target > row.get(mid)) {
            return binarySearch(row, target, mid+1 , end);
        } else {
            return binarySearch(row, target, start, mid-1);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>(2);
        ArrayList<Integer> row0 = new ArrayList<Integer>(2);
        row0.add(17);
        row0.add(22);
        matrix.add(row0);
        ArrayList<Integer> row1 = new ArrayList<Integer>(2);
        row1.add(27);
        row1.add(28);
        matrix.add(row1);

        ArrayList<Integer> row2 = new ArrayList<Integer>(2);
        row2.add(100);
        row2.add(100);
        matrix.add(row2);
        System.out.println(matrix);
        System.out.println(searchMatrix(matrix, 50));
    }

    /**
     * Think about the edge case:
     * What happen if mid is 0, or -1?
     * Read log carefully, an stack overflow means that some index is out of bound
     * and becomes an infinite loop
     *
     * Notice that the arrays are sorted.
     *
     * Time complexity: O(n(log n))
     */

}
