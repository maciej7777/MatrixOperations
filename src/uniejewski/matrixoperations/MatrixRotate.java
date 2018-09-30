package uniejewski.matrixoperations;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class MatrixRotate {
    public static void main(String[] args) {

        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        System.out.println("Example with new array: ");
        int[][] example = rotateWithNewArray(array);
        printMatrix(example);

        System.out.println("Example in place: ");
        int[][] exampleInPlace = rotateInPlace(array);
        printMatrix(exampleInPlace);
    }

    private static int[][] rotateInPlace(int[][] array) {
        final int m = array.length;
        final int n = array[0].length;

        if (m != n) {
            throw new ValueException("This matrix cannot be rotated in place, as it has different dimensions' sizes.");
        }

        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < m - 1 - i; j++) {
                int tmp = array[j][i];
                array[j][i] = array[m - 1 - i][j];
                array[m - 1 - i][j] = array[m - 1 - j][m - 1 - i];
                array[m - 1 - j][m - 1 - i] = array[i][m - 1 - j];
                array[i][m - 1 - j] = tmp;
            }
        }

        return array;
    }

    private static int[][] rotateWithNewArray(int[][] array) {
        final int m = array.length;
        final int n = array[0].length;
        int[][] newArray = new int[n][m];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                newArray[c][m - 1 - r] = array[r][c];
            }
        }
        return newArray;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + ", ");
            }
            System.out.println();
        }
    }

}
