package com.sorting.sumit;

public class MergeSort {

	int[] temp = new int[9];
	static int[] arr = new int[9];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,7,1,3,9,6,2};
		new MergeSort().mergeSort(a, 0, a.length -1);
		for(int k : a){
			System.out.print(k+",");
		}
	}

	public void mergeSort(int[] a,int low,int high){
		if(low < high){
			int mid = (low+high)/2;
			mergeSort(a,low, mid);
			mergeSort(a,mid+1, high);
			merge(a, low, mid, high);
		}
	}
	
	public void merge(int[] a,int low,int mid,int high){
		try{
			for(int i = low;i<=high;i++){
				temp[i] = a[i];
			}
			int l = low;
			int m = mid+1;
			int h = low;
			while(l <= mid && m <= high){
				if(temp[l] <= temp[m]){
					a[h] = temp[l];
					l++;
				}
				else{
					a[h] = temp[m];
					m++;
				}
				h++;
			}
			while(l <= mid){
				a[h] = temp[l];
				l++;h++;
			}
			while(m <= high){
				a[h] = temp[m];
				m++;h++;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
