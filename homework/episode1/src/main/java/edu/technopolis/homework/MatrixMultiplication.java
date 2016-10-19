package edu.technopolis.homework;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    public static void main(String... args) {
        // Checking arguments
        if (args.length < 6) {
            System.out.println("Not enough arguments");
            return;
        }

        // Reading input
        int a_row, a_column, b_row, b_column;
        a_row = Integer.parseInt(args[0]);
        a_column = Integer.parseInt(args[1]);

        b_row = Integer.parseInt(args[2]);
        b_column = Integer.parseInt(args[3]);

        // Checking whether it is correct or not
        if (a_column != b_row) {
            System.out.println("You can't multiply these matrices :(");
            return;
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

        // Counting the result matrix
        int result_matrix[][] = new int[a_row][b_column];

        for (int i = 0; i < a_row; i++) {
            for (int j = 0; j < b_column; j++) {
                int multiplied_element = 0;
                for (int k = 0; k < a_column; k++) {
                    multiplied_element += a_matrix[i][k] * b_matrix[k][j];
                }
                result_matrix[i][j] = multiplied_element;
            }
        }

        // Prints the result
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < a_row; i++) {
            for (int j = 0; j < b_column; j++) {
                stringBuilder.append(result_matrix[i][j]);
                stringBuilder.append("\t");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}