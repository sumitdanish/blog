package com.sumit.mattrix;

public class LargestSquareSubMattrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int r = 6;
		int c = 5;
		new LargestSquareSubMattrix().largestMattrix(mat, r, c);
	}

	public void largestMattrix(int[][] mat, int r, int c) {
		int[][] s = new int[r][c];
		for (int i = 0; i < r; i++) {
			s[i][0] = mat[i][0];
		}
		for (int j = 0; j < c; j++) {
			s[0][j] = mat[0][j];
		}
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (mat[i][j] == 1) {
					s[i][j] = min1(s[i - 1][j - 1], s[i][j - 1], s[i - 1][j]) + 1;
				} else {
					s[i][j] = 0;
				}
			}
		}
		int max = 0;
		int min_i = 0;
		int min_j = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (max < s[i][j]) {
					min_i = i;
					min_j = j;
					max = s[i][j];
				}
			}
		}
		System.out.println(max);
		for (int i = min_i; i > min_i - max; i--) {
			for (int j = min_j; j > min_j - max; j--) {
				System.out.print(mat[i][j] + ",");
			}
			System.out.println("\n");
		}
	}
	// System.out.println(min_i+" : "+min_j);

	public int min(int a, int b) {
		return a > b ? b : a;
	}

	public int min1(int a, int b, int c) {
		return a > min(b, c) ? min(b, c) : a;
	}

}
