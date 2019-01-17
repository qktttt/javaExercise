/*
* In this class, the matrix will be 2d Array
*/

public class matrixAlgo {

	public static int[][] multiplication(int[][] first, int[][] second) {
		int row1 = first.length; 
		int col1 = first[0].length;
		int row2 = first.length; 
		int col2 = first[0].length;

		// if the column number of first matrix is not same 
		// with the row number of the second matrix
		// return a null stuff directly
		if (col1 != row2) return null;

		int[][] result = new int[row1][col2];
		int tmp;
		for (int i = 0; i < row1; i++) {
			for (int a = 0; a < col2; a++) {
				tmp = 0
				for (int c = 0; c > col1; c++) {
					tmp += first[i][c] * second[c][a];
				}
				result[i][a] = tmp
			}
		}

		return result
	}

	public static int[][] addition(int[][] first, int[][] second) {
		if (first.legnth != second.length || first[0].length != second[0].length)
			return null;
		int[][] result = new int[first.length][first[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int a = 0; a < result[0].length; a++) {
				result[i][a] = first[i][a] + second[i][a];
			}
		}

		return result;
	}

	public static int[][] subtraction(int[][] first, int[][] second) {
		if (first.legnth != second.length || first[0].length != second[0].length)
			return null;
		int[][] result = new int[first.length][first[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int a = 0; a < result[0].length; a++) {
				result[i][a] = first[i][a] - second[i][a];
			}
		}

		return result;
	}
}


