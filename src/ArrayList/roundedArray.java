package src.ArrayList;

/**
 *
 *  Input:
 arrayA:  [xi, xi, xi ];
 T = rounded total of {xi+ xi+ xi}
 Output:
 arrayB [yi, yi, yi] = T such that
 sum of absolute [yi - xi] is the minumum

 * Base price: 30.5
 * Guest fee: 1.5
 * Extra fee: 2.5
 * Total 34.5 --> 35

 * arrayB: [31, 1, 2] (best result)
 * arrayB: [30, 2, 2] (best result)
 * arrayB: [30, 1, 3]
 *
 * sum of absolute:
 * 0.6, 0.4, 0.3 = 1.3
 * 0.4, 0.4, 0.7 = 1.5
 *
 */
public class roundedArray {

    public static void main(String[] args) {
        float[] arrayA = {30.6f, 3.1f, 2.5f};

        float t = 0;
        System.out.print("Input: ");
        for (int i=0; i < arrayA.length; i++) {
            System.out.print(arrayA[i] + ",");
            t +=arrayA[i];
        }

        int T = Math.round(t);
        System.out.println("    T: " + T);
        int[] output = minRoundedOutput(arrayA, T);

        System.out.println("Optimal Array B");
        for (int i=0; i < output.length; i++) {
            System.out.print(output[i] + ",");
        }

    }

    private static int[] minRoundedOutput(float[] arrayA, int T){
        int[] arrayB = new int[arrayA.length];
        float[] diff = new float[arrayA.length];
        int currentRoundedSum = 0;

        // first round each element in array A
        // create a diff array that keeps track of | xi - yi |
        for (int i=0; i < arrayA.length; i++) {
            arrayB[i] = Math.round(arrayA[i]);
            diff[i] = Math.abs(arrayA[i] - arrayB[i]);
            currentRoundedSum += arrayB[i];
        }

        if ( currentRoundedSum != T) {
            int deficit = T - currentRoundedSum;
            float currMax = diff[0];
            int currMaxIndex = 0;

            for (int i=1; i < diff.length; i++) {
                if ( diff[i] > currMax) {
                    currMax = diff[i];
                    currMaxIndex = i;
                }
            }
            // should decrease one of the number
            int temp = arrayB[currMaxIndex] + 1;
            if ( deficit < 0 ) {
                temp = arrayB[currMaxIndex] - 1;
                arrayB[currMaxIndex] = temp;
            }  // should increase one of the number
            arrayB[currMaxIndex] = temp;
        }
        return arrayB;
    }
}
