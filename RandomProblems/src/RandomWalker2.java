import java.util.Arrays;

import javax.swing.ListCellRenderer;

public class RandomWalker2 {

    public static double[][] randomWalker2(int n, double[] left, double[] right, int k) {
        double[][] possibilities = new double[k + 1][n];

        for (int i = 0; i < k + 1; i++) { // rows steps
            for (int c = 0; c < n; c++) { // columns position
                // if (i == 1 && c == 1) {
                if (i == 0 && c == 0) {
                    possibilities[0][0] = 1;
                } else {
                    double rightPossibility = 0, leftPossibility = 0;
                    if (i - 1 >= 0 && c - 1 >= 0) {
                        rightPossibility = possibilities[i - 1][c - 1] * right[c - 1]; // going right}

                    }
                    if (i - 1 >= 0 && c + 1 < n) {
                        leftPossibility = possibilities[i - 1][c + 1] * left[c + 1]; // going left
                    }
                    possibilities[i][c] = rightPossibility + leftPossibility;
                }
                // }

            }
        }
        return possibilities;
    }

    public static void main(String[] args) {
        int n = 10;
        double[] right = new double[n];
        double[] left = new double[n];
        right[0] = 1;
        right[n - 1] = 0;
        left[0] = 0;
        left[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) {
            right[i] = 0.5;
            left[i] = 0.5;
        }
        System.out.println(Arrays.toString(right));
        double arr[][] = randomWalker2(n, left, right, 14);
        for (int i = 0; i < arr.length; i++) {
            double sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum = arr[i][j] + sum;
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
            System.out.println("sum:" + sum);
        }
    }

}