package src.BinarySearch;

/**
 * Should consider integer overflow..
 * So dividing apporach is better.
 * Created by liyangzhang on 2016-06-23.
 */
public class SquareRootOfInteger {

    public static int sqrt(int a) {

        if (a == 0 || a ==1 ) {
            return a;
        }
        int start =1;
        int end = a/2;
        int answer = a;
        while (start <= end) {

            int mid = (start + end) / 2;
            if (mid <= a / mid) {
                start = mid + 1;
                answer = mid;
            }  else {
                end = mid - 1;
            }

        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(sqrt(930675566));
        System.out.println(sqrt(25));
        System.out.println(sqrt(2));
    }

}
