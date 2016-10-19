package edu.technopolis.homework;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    public static void main(String... args) {
        new MatrixMultiplication().run(args);
    }

    private void run(String... args) {

        // Checking arguments
        if (args.length < 6) {
            throw new IllegalArgumentException("Not enough arguments.");
        }

        // Reading input
        int a_row, a_column, b_row, b_column;
        a_row = Integer.parseInt(args[0]);
        a_column = Integer.parseInt(args[1]);

        b_row = Integer.parseInt(args[2]);
        b_column = Integer.parseInt(args[3]);

        // Checking whether it is correct or not
        if (a_column != b_row) {
            throw new IllegalArgumentException("You can't multiply these matrices. Check dimensions.");
        }

        int a_matrix[][] = new int[a_row][a_column];
        int b_matrix[][] = new int[b_row][b_column];
        int index = 3;

        // Reading first matrix
        for (int i = 0; i < a_row; i++) {
            for (int j = 0; j < a_column; j++) {
                a_matrix[i][j] = Integer.parseInt(args[++index]);
            }
        }

        // Reading second matrix
        for (int i = 0; i < b_row; i++) {
            for (int j = 0; j < b_column; j++) {
                b_matrix[i][j] = Integer.parseInt(args[++index]);
            }
        }

        int result_matrix[][] = multiply(a_matrix, b_matrix);
        new MatrixMultiplication().print(result_matrix);
    }

    private int[][] multiply(int[][] a_matrix, int[][] b_matrix) {
        int result_matrix[][] = new int[a_matrix.length][b_matrix[0].length];
        for (int i = 0; i < a_matrix.length; i++) {
            for (int j = 0; j < b_matrix[0].length; j++) {
                int multiplied_element = 0;
                for (int k = 0; k < b_matrix.length; k++) {
                    multiplied_element += a_matrix[i][k] * b_matrix[k][j];
                }
                result_matrix[i][j] = multiplied_element;
            }
        }
        return result_matrix;
    }

    private void print(int result_matrix[][]) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result_matrix.length; i++) {
            for (int j = 0; j < result_matrix[0].length; j++) {
                stringBuilder.append(result_matrix[i][j]);
                stringBuilder.append("\t");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}