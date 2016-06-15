package com.sumit.mattrix;

public class SprialMattrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = { {1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };
		int row = 3;
		int col = 6;

		new SprialMattrix().sprial(m,row,col);
	}

	public void sprial(int[][] mat,int row,int col){
		int l = 0;
		int k = 0;
		while(k < row && l < col){
			for(int i = l;i<col;i++){
				System.out.print(mat[k][i]+",");
			}
			k++;
			for(int i = k ; i< row;i++){
				System.out.print(mat[i][col - 1]+",");
			}
			col--;
			if(k < row){
				for(int i = col-1;i>=l;i--){
					System.out.print(mat[row-1][i]+",");
				}
				row--;
			}
			if(l < col){
				for(int j = row-1  ; j >=k; j --){
					System.out.print(mat[j][l]+",");
				}
				l++;
			}
		}

	}


}
