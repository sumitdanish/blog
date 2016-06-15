package com.sumit.mattrix;

public class SearchInSortedMattrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		int row = 4;
		int col =4;
		new SearchInSortedMattrix().search(mat,35,row,col);
	}

	public void search(int[][] mat,int x,int row,int col){
		int i = 0;
		int j = row - 1;
		while(i < col && j >=0){
			if(mat[i][j] == x){
				System.out.println("Found : "+i+" > "+j);
				break;
			}
			if(x < mat[i][j]){
				j--;
			}else{
				i++;
			}
		}
	}


}
