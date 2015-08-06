package com.zy.test;

public class Array_MaxNum {

	public static void main(String[] args) {
		Array_MaxNum mn = new Array_MaxNum();
		int a[] = {0,16,2,3,4,5,10,7,8,9,23};
		System.out.println(mn.maxNum(a,0));
	}
	
	public int maxNum(int a[],int begin){
		int len = a.length-begin;
		if(len==1)
			return a[begin];
		else{
			return max(a[begin],maxNum(a,begin+1));
		}
	}
	private int max(int a, int b){
		return a>b? a:b;
	}

}
