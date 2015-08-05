package com.zy.test;

public class Array_Shift_K {

	public static void main(String[] args) {
		int arr[] ={1,2,3,4,5,6,7,8};
		shift_k(arr,2);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public static void shift_k(int a[],int k){
		int n = a.length;
		k = k%n; //·ÀÖ¹k>n
		reverse(a,n-k,n-1);
		reverse(a,0,n-k-1);
		reverse(a,0,n-1);
	}
	public static void reverse(int a[],int b,int e){
		for(;b<e;b++,e--){
			int temp = a[e];
			a[e] = a[b];
			a[b] = temp;
		}
	}

}
