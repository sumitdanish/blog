package com.sorting.sumit;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,7,1,3,9,6,2};
		new InsertionSort().sort(a);
	}
	
	public void sort(int[] a){
		try{
			int key = 0;
			int i = 0;
			for(int j = 1;j<a.length;j++){
				key = a[j];
				i = j-1;
				while(i >= 0 && a[i] >= key){
					a[i+1] = a[i];
					i--;
				}
				a[i+1] = key;
			}
			for(int l = 0; l <a.length ; l++){
				System.out.print(a[l]+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
