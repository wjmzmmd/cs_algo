package graph.utils;

/**
 * Created by qin on 16-9-15.
 */
public class PrintUtil {

    public static String printMatrix(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                stringBuilder.append(matrix[i][j]);
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
