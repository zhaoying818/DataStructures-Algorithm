package com.zy.test;

import java.util.Arrays;

public class Array_FindSum {
	
	public static void findSum(int[] a,int sum){
		Arrays.sort(a);
		int begin = 0;
		int end = a.length-1;
		while(begin<end){
			if(a[begin]+a[end]<sum){
				begin++;
			}
			else if(a[begin]+a[end]>sum){
				end--;
			}
			else{
				System.out.println(a[begin] + "+" + a[end] + "=" + sum);
				begin++;
				end--;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {1,17,2,6,3,14,5,15,15,10,10};
		findSum(arr,20);

	}

}
