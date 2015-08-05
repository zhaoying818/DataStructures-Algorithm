package com.zy.test;

public class Array_MaxMin {
	static int Max;
	static int Min;

	public static void main(String[] args) {
		int[] arr = {5,2,2,2,2};
		GetMaxMin(arr);
		System.out.println("max = " +Max);
		System.out.println("min = "+ Min);

	}
	
	public static void GetMaxMin(int array[]){
		Max = array[0];
		Min = array[0];
		int len = array.length;
		for(int i=1; i<len-1;i=i+2){
			if(i+1>len){
				if(array[i]>Max)
					Max = array[i];
				if(array[i]<Min)
					Min = array[i];
			}
			if(array[i]>array[i+1]){
				if(array[i]>Max)
					Max = array[i];
				if(array[i+1]<Min)
					Min = array[i+1];
			}
			else if(array[i]<array[i+1]){
				if(array[i+1]>Max)
					Max = array[i+1];
				if(array[i]<Min)
					Min = array[i];
			}
			else {
				if(array[i]>Max)
					Max = array[i];
				if(array[i]<Min)
					Min = array[i];
			}
		}
	}

}
