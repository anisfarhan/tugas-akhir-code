import java.util.Scanner;

public class MatrixMultiplication {

    // time complexity: O(r1 * c1 * c2)
    // space complexity: O(r1 * c2) for the result matrix
    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int r1 = matrix1.length;
        int c1 = matrix1[0].length;
        int r2 = matrix2.length;
        int c2 = matrix2[0].length;

        if (c1 != r2) {
            System.out.println("The number of columns of the first matrix must be equal to the number of rows of the second matrix.");
            return null;
        }

        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.println("Enter the number of rows and columns of the first matrix: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        // System.out.println("Enter the first matrix: ");
        int[][] matrix1 = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        // System.out.println("Enter the number of rows and columns of the second matrix: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        // System.out.println("Enter the second matrix: ");
        int[][] matrix2 = new int[r2][c2];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        int[][] result = multiplyMatrices(matrix1, matrix2);

        if (result != null) {
            // System.out.println("The product of the two matrices is: ");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix multiplication is not possible.");
        }
    }
}
