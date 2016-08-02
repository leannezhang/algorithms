package BinarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * O(log n)
 * Created by liyangzhang on 2016-06-23.
 */
public class CountElementOccurence {

    public static int findCount(final List<Integer> a, int b) {

        int first = findFirstOccurance(a, b);
        int last;
        if (first != -1 ) {
            last = findLastOccurance(a,b);
            return last - first + 1;
        }
        return 0;

    }
    private static int findFirstOccurance(final List<Integer> a, int b) {
        int start = 0;
        int end = a.size() - 1;
        int mid = (start + end) / 2;
        int index = -1;

        while (start <= end) {
            if ( a.get(mid).intValue() == b) {
                index = mid;
                end = mid - 1; // search to the left
            }
            else if ( a.get(mid).intValue() > b) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return index;
    }


    private static int findLastOccurance(final List<Integer> a, int b) {
        int start = 0;
        int end = a.size() - 1;
        int mid = (start + end) / 2;
        int index = -1;

        while (start <= end) {
            if ( a.get(mid).intValue() == b) {
                index = mid;
                start = mid + 1; // search to the right
            }
            else if ( a.get(mid).intValue() > b) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }

        return index;
    }


    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(5, 7, 7, 8, 8, 10);
        System.out.println(findCount(a, 8));
        System.out.println(findFirstOccurance(a, 8));
        System.out.println(findLastOccurance(a, 8));
    }
}
