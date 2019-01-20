/*
* In this class, the matrix will be 2d Array
* This class contains algorithm for computing 
* matrixs, linear function, inverse, det
* unitMatrix, multiplication, and etc.
* This file is just for fun, practice of linear algebra
*/

public class matrixAlgo {

	public static double[][] multiplication(double[][] first, double[][] second) {
		int row1 = first.length; 
		int col1 = first[0].length;
		int row2 = first.length; 
		int col2 = first[0].length;

		// if the column number of first matrix is not same 
		// with the row number of the second matrix
		// return a null stuff directly
		if (col1 != row2) return null;

		double[][] result = new double[row1][col2];
		int tmp;
		for (int i = 0; i < row1; i++) {
			for (int a = 0; a < col2; a++) {
				tmp = 0;
				for (int c = 0; c > col1; c++) {
					tmp += first[i][c] * second[c][a];
				}
				result[i][a] = tmp;
			}
		}

		return result;
	}

	public static double[][] addition(double[][] first, double[][] second) {
		if (first.length != second.length || first[0].length != second[0].length)
			return null;
		double[][] result = new double[first.length][first[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int a = 0; a < result[0].length; a++) {
				result[i][a] = first[i][a] + second[i][a];
			}
		}

		return result;
	}

	public static double[][] subtraction(double[][] first, double[][] second) {
		if (first.length != second.length || first[0].length != second[0].length)
			return null;
		double[][] result = new double[first.length][first[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int a = 0; a < result[0].length; a++) {
				result[i][a] = first[i][a] - second[i][a];
			}
		}

		return result;
	}

	public static double[][] getTMatrix(double[][] matrix) {
		double[][] result = new double[matrix[0].length][matrix.length];

		for(int i = 0; i < matrix.length; i++)
			for(int a = 0; a < matrix[0].length; a++)
				result[a][i] = matrix[i][a];

		return result;
	}

	public static boolean isSquare(double[][] matrix) {
		return isValid(matrix) && matrix.length == matrix[0].length;
	}

	public static boolean isValid(double[][] matrix) {
		return !(matrix.length == 0 || matrix[0].length == 0);
	}

	public static double[][] unitMatrix(int matrixLevel) {
		double[][] result = new double[matrixLevel][matrixLevel];
		for(int i = 0; i < matrixLevel; i++)
			result[i][i] = 1;
		return result;
	}

	public static void printMatrix(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int a = 0; a < matrix[0].length; a++) {
				System.out.print(matrix[i][a] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}


	public static void matrixConvert(double[][] first, double[][] second) {
		double coefficient;
		
		for (int i = 0; i < first.length; i++) {
			coefficient = first[i][i] / 1;
			for (int a = i; a < first[i].length; a++)
				first[i][a] /= coefficient;
			for (int a = 0; a  < second[i].length; a++)
				second[i][a]  /= coefficient;
			for (int below = i + 1; below < first.length; below++) {
				coefficient = first[below][i] / 1;

				for(int a = i; a < first[below].length; a++)
					first[below][a] -= (coefficient * first[i][a]);
				for(int a = 0; a < second[below].length; a++)
					second[below][a] -= (coefficient * second[i][a]);
			}
		}

		for (int i = first.length - 1; i > -1; i--) {
			for (int above = i - 1; above > -1; above--) {
				coefficient = first[above][i] / 1;

				for(int a = above + 1; a < first[above].length; a++)
					first[above][a] -= (coefficient * first[i][a]);
				for(int a = 0; a < second[above].length; a++)
					second[above][a] -= (coefficient * second[i][a]);	
			}
		}
	}

	public static double[][] getInverseMatrix(double[][] matrix) {
		if ( !isSquare(matrix) ) return null;
		if ( getDet(matrix) == 0) return null;

		double[][] matrixCopy = copyMatrix(matrix);
		double[][] unitM = unitMatrix(matrix.length);

		matrixConvert(matrixCopy, unitM);

		return unitM;
	}

	public static double[][] copyMatrix(double[][] matrix) {
		double[][] result = new double[matrix.length][matrix.length != 0 ? matrix[0].length : 0];
		
		for(int i = 0; i < matrix.length; i++) 
			for(int a = 0; a < matrix[0].length; a++)
				result[i][a] = matrix[i][a];

		return result;
	}

	public static double getDet(double[][] matrix) {
		double diagProdTotal = 0;
		double rDiagProdTotal = 0;
		double diagProd;
		double rDiagProd;

		if (matrix.length == 0 || matrix[0].length == 0) return Double.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			diagProd = rDiagProd = 1;
			for (int a = 0; a < matrix.length; a++) {
				diagProd *= matrix[(i + a) % matrix.length][a];
				rDiagProd *= matrix[i - a < 0 ? matrix.length + i - a 
									: i - a][a];
			}
			diagProdTotal += diagProd;
			rDiagProdTotal += rDiagProd;
		}

		return diagProdTotal - rDiagProdTotal;
	}

	public static void main(String[] args) {
		double[][] test = {{1, 1}, {0, 1}};
		double[][] test1 = {{5}, {3}};
		System.out.println(-2 % 6);
		matrixConvert(test, test1);
		printMatrix(test);
		printMatrix(test1);


		printMatrix(getInverseMatrix(new double[][] {
			{1, 0, 0, 0},
			{0, 2, 0, 0},
			{0, 0, 3, 0},
			{0, 0, 0, 4}
		}));
		double[][] test3 = new double[500][500];
		for (int i = 0; i < 500; i++) test3[i][i] = i + 1;
		//printMatrix(getInverseMatrix(test3));
		printMatrix(getTMatrix(new double[][] {
			{2, 0, 0, 0},
			{0, 2, 0, 1},
			{1, 0, 2, 0},
			{0, 0, 0, 2}
		}));
	}
}


