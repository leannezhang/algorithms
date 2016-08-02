package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liyangzhang on 2016-06-25.
 */
public class RotationCount {

        // DO NOT MODIFY THE LIST
        public static int findMin(final List<Integer> a) {
            if ( a.size() == 0 ) {
                return -1;
            }

            int start = 0;
            int end = a.size() - 1;
            int mid = (start + end) / 2;

            // already sorted

            if (a.get(start) <= a.get(end)) {

                return a.get(start);
            }

            return FindRotationCountHelper(a, start, mid, end);
        }


        public static int FindRotationCountHelper(List<Integer> a, int start, int mid, int end) {

            if (start > end ) {
                return -1;
            }
            else {
                int next = (mid+1)% a.size();
                int prev = (mid + a.size() - 1 ) % a.size();

                if ( a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev) ) {
                    return a.get(mid);
                }
                else if (a.get(mid) <= a.get(end)) {
                    end = mid - 1; //right is already sorted
                    mid = (start + end )/2;
                    return (FindRotationCountHelper(a, start, mid, end));
                }
                else { //( A[mid] >= A[end])
                    start = mid + 1; // left is already sorted
                    mid = (start + end )/2;
                    return (FindRotationCountHelper(a, start, mid, end));
                }
            }
        }

        public static void main(String[] args) {
//            int[] A = {4,5,6,7,0,0,1,2};
            List<Integer> A = new ArrayList<>(Arrays.asList(1));
            List<Integer> B = new ArrayList<>(Arrays.asList(40342, 40766, 41307, 42639, 42777,
                    46079, 47038, 47923, 48064, 48083, 49760, 49871, 51000, 51035, 53186, 53499,
                    53895, 59118, 60467, 60498, 60764, 65158, 65838, 65885, 65919, 66638, 66807,
                    66989, 67114, 68119, 68146, 68584, 69494, 70914, 72312, 72432, 74536, 77038,
                    77720, 78590, 78769, 78894, 80169, 81717, 81760, 82124, 82583, 82620, 82877,
                    83131, 84932, 85050, 85358, 89896, 90991, 91348, 91376, 92786, 93626, 93688,
                    94972, 95064, 96240, 96308, 96755, 97197, 97243, 98049, 98407, 98998, 99785,
                    350, 2563, 3075, 3161, 3519, 4176, 4371, 5885, 6054, 6495, 7218, 7734, 9235,
                    11899, 13070, 14002, 16258, 16309, 16461, 17338, 19141, 19526, 21256, 21507,
                    21945, 22753, 25029, 25524, 27311, 27609, 28217, 30854, 32721, 33184, 34190,
                    35040, 35753, 36144, 37342));
            List<Integer> C = new ArrayList<>(Arrays.asList(60437, 60449, 61231, 61617, 61632,
                    61722, 61818, 61948, 62943, 62967, 63011, 63823, 65145, 65804, 65818, 66739,
                    66857, 67595, 69350, 71102, 71899, 72411, 72686, 73517, 74932, 76094, 76343,
                    76903, 77288, 77426, 77683, 78292, 79165, 79675, 79677, 80362, 80879, 80923,
                    82952, 83789, 83890, 84804, 85330, 87968, 88540, 89290, 89427, 89757, 89878,
                    91137, 91955, 92820, 93262, 94680, 95100, 96071, 96280, 96537, 96556, 97945,
                    98173, 98583, 99869, 76, 426, 1579, 1865, 4324, 4634, 5149, 5348, 7859, 8459,
                    9818, 10649, 10688, 11072, 11522, 12704, 12954, 13010, 13044, 14013, 14843,
                    16571, 16725, 16843, 17396, 17397, 17670, 17753, 19722, 20831, 21004, 21501,
                    21987, 22809, 23801, 24161, 24351, 24772, 24833, 25453, 25847, 25854, 25882,
                    26732, 28087, 28646, 33173, 33585, 35508, 36471, 37394, 37763, 37817, 41076,
                    41629, 41693, 41700, 42126, 42509, 42932, 43315, 44765, 45646, 46088, 47469,
                    47837, 48520, 49249, 49968, 51178, 51998, 52215, 53059, 53066, 53347, 54722,
                    54910, 55927, 58494, 59801, 60213));
            System.out.println("The number where it's rotated: ");
            System.out.println(findMin(A));
        }


}
