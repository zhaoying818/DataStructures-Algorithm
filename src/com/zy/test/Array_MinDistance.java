package com.zy.test;

public class Array_MinDistance {

	public static void main(String[] args) {
		int a[] = {4,5,6,4,7,4,6,4,7,8,5,6,4,3,10,8};
		System.out.println(getMinDistance(a, 4, 8));

	}
	
	public static int getMinDistance(int[] a,int n1,int n2){
		if(a==null)
			return Integer.MIN_VALUE;
		int len = a.length;
		int n1_index = -1;
		int n2_index = -1;
		int minDis = Integer.MIN_VALUE +1;
		for(int i=0;i<len;i++){
			if(a[i]==n1){
				n1_index = i;
				if(n2_index>=0)
					minDis = min(Math.abs(minDis),Math.abs(n1_index-n2_index));
			}
			if(a[i]==n2){
				n2_index = i;
				if(n1_index>=0)
					minDis = min(Math.abs(minDis),Math.abs(n2_index-n1_index));
			}
		}
		return minDis;
	}
	private static int min(int m,int n){
		return m>n?n:m;
	}

}
