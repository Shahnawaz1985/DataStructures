package com.bac.matrix;

public class BinarySymmetricMatrix {
	
	public static void main(String[] args) {
		int mat[][] = {
		        { 0, 0, 1 },
		        { 1, 1, 1 },
		        { 1, 0, 0 }
		    };
		printMatrix(mat);
		System.out.println("Transpose of Matrix:");
		int[][] transpose = transpose(mat);		
		printMatrix(transpose);
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
	
	private static int[][] transpose(int[][] matrix){
		int transpose[][] = matrix;
		for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix.length; j++) {
	            transpose[i][j] = matrix[j][i];
	        }
	        }
		return transpose;
	}
}
