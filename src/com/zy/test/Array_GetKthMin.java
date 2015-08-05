package com.zy.test;

public class Array_GetKthMin {

	public static void main(String[] args) {
		int a[] = {1,5,6,2,8,0,6};
		int KthMin = getKthMin(a, 4);
		System.out.println(KthMin);

	}
	
	public static int getKthMin(int arr[],int k){
		if(arr==null)
			return Integer.MIN_VALUE;
		if(arr.length<k)
			return Integer.MIN_VALUE;
		return quikSort(arr, 0, arr.length-1, k);
	}
	public static int quikSort(int arr[], int low, int high, int k){
		int i, j;
		int tmp;
		if(low>high)
			return Integer.MAX_VALUE;
		i = low+1;
		j =high;
		tmp=arr[i];
		while(i<j){
			while(i<j && arr[j]>=tmp)
				j--;
			if(i<j)
				arr[i++] = arr[j];
			while(i<j && arr[i]<tmp)
				i++;
			if(i<j)
				arr[j--] = arr[i];
		}
		arr[i] = tmp;
		if(i+1==k)
			return tmp;
		else if(i+1>k)
			return quikSort(arr,low,i-1,k);
		else
			return quikSort(arr,i+1,high,k);
	}

}
