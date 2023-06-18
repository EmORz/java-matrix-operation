import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter cols: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.print("Enter elements of matrix: ");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
                
            }
        }

        System.out.println("Matrix is1: ");
        printMatrix(matrix);

        System.out.print("Sum of matrixs is: ");
        int[][] secondMatrix = readMatrixFromInput(scanner, rows, cols);
        int[][] sum = addMatrix(matrix, secondMatrix);

        printMatrix(sum);

        System.out.print("Subtract of matrixs: ");
        int[][] diffrence = substractMatrix(matrix, secondMatrix);
        printMatrix(diffrence);

        System.out.print("Production of matrixs: ");
        System.out.print("Enter row of second matrix: ");
        int secRows = scanner.nextInt();
        System.out.print("Enter cols of second matrix: ");
        int secCols = scanner.nextInt();
        int[][] secondMatrixProduction = readMatrixFromInput(scanner, secRows, secCols);
        int[][] production = multiplyMatrix(matrix, secondMatrixProduction);
        printMatrix(production);

        System.out.print("Check matrix to E: ");
        boolean isIdentityMatrix = isIdentityMatrix(matrix);
        if (isIdentityMatrix) {
            System.out.print("The matrix can be transformed into the identity matrix.");
        }else {
            System.out.print("The matrix cant't be transformed into the identity matrix.");
        }

    }

    private static boolean isIdentityMatrix(int[][] matrix) {
        int n = matrix.length;

        if (n != matrix[0].length) {
            return false;
        }

        for (int i = 0; i < n ; i++) {
            if (matrix[i][i]!=1) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j && matrix[i][j]!=0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[][] multiplyMatrix(int[][] matrix, int[][] secondMatrixProduction) {
        int rows = matrix.length;
        int cols1 = matrix[0].length;
        int cols2 = secondMatrixProduction[0].length;

        if (rows!=cols2){
            System.out.print("The matrix can't be multiply!");
            return null;
        }

        int[][] result = new int[rows][cols2];

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix[i][k]*secondMatrixProduction[k][j];
                }
            }
        }

        return result;
    }

    private static int[][] substractMatrix(int[][] matrix, int[][] secondMatrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j]-secondMatrix[i][j];
            }
        }
        return result;
    }

    private static int[][] addMatrix(int[][] matrix, int[][] secondMatrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j]+secondMatrix[i][j];
            }
        }
        return result;

    }

    private static int[][] readMatrixFromInput(Scanner scanner, int rows, int cols) {

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}