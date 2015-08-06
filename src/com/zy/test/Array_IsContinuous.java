package com.zy.test;

public class Array_IsContinuous {

	public static void main(String[] args) {

		int a[] = {8,7,6,0,5};
		if(isContinuous(a))
			System.out.println("数组{8,7,6,0,6}连续相邻");
		else
			System.out.println("数组{8,7,6,0,6}不连续相邻");
	}
	
	public static Boolean isContinuous(int[] a ){
		int n= a.length;
		int min = -1;
		int max = -1;
		for(int i=0;i<n;i++){
			if(a[i]!=0){
				if(min>a[i] || min==-1)
				min = a[i];
				if(max<a[i] || max==-1)
				max = a[i];
			}
		}
		if(max-min>n-1)
			return false;
		else
			return true;
	}

}
