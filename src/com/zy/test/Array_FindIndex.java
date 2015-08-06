package com.zy.test;

public class Array_FindIndex {

	public static void main(String[] args) {
		int a[] = {3,4,5,6,5,6,7,8,9,8};
		System.out.println(findIndex(a, 8));

	}
	
	public static int findIndex(int a[],int t){
		if(a==null)
			return -1;
		int len = a.length;
		int i=0;
		while(i<len){
			if(a[i]==t){
				return i;
			}else{
				i += Math.abs(t-a[i]);
			}
		}
		return -1;
	}

}
