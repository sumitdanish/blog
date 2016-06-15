package com.sorting.sumit;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 3, 10, 13, 15, 8, 12};
		bubbleSort(a);
		print(a);

	}

	public static void bubbleSort(int[] a){
		try{
			int count = 0;
			boolean flag = true;
			for(int i = 1;i<a.length && flag;i++){
				flag = false;
				for(int j = i;j<a.length;j++){
					if(a[j-1] > a[j]){
						count++;
						flag = true;
						int temp = a[j];
						a[j] = a[j-1];
						a[j-1] = temp;
					}
				}
			}
			System.out.println(count);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void print(int[] a){
		for(int k : a){
			System.out.print(k+",");
		}
	}
	
}
