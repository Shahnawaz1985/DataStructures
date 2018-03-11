package com.bac.matrix;

public class Simple2DMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = new int[2][3]; 
		populate2DMatrix(matrix);
		printMatrix(matrix);
		int mat1[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 } };
		System.out.println("Actual Matrix");
		printMatrix(mat1);
		mirrorMatrix(mat1);
		
		int mat2[][] = { { 10, 20, 30, 40 },
                { 50, 60, 70, 80 },
                { 90, 100, 110, 120 } };
		System.out.println("Second Matrix");
		printMatrix(mat2);
		
		int mat3[][] = sum(mat1, mat2);
		
		System.out.println("Sum of mat1 and mat2 :");
		printMatrix(mat3);
		
	}

	private static int[][] sum(int[][] mat1, int[][] mat2) {
		int temp_matrix[][] = {{0}};
		if(mat1.length == mat2.length) {
			temp_matrix = new int[mat1.length][mat1[0].length];
			for(int i=0; i<mat1.length; i++) {				
				for(int j=0;j<mat1[i].length;j++) {
					temp_matrix[i][j] = mat1[i][j]+mat2[i][j];
				}
			}
		}
		return temp_matrix;
	}

	private static void populate2DMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j] = j*19+2;
			}
		}
	}
	
	private static void printMatrix(int[][] matrix) {
		for(int i =0; i<matrix.length; i++) {
			System.out.print("[ ");
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");				
			}
			System.out.println("]");
		}
	}
	
	private static void mirrorMatrix(int[][] matrix) {
		System.out.println("Mirror of matrix:");
		for(int i=0; i<matrix.length;i++) {
			System.out.print("[ ");
			for (int j=(matrix[i].length-1);j>=0;j--) {				
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}
}
