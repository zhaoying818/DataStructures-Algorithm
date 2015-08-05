package com.zy.test;

public class Array_SecondMax {

	public static void main(String[] args) {
		
		int[] array = {7,3,9,19,40,5,6,2,1};
		System.out.println(findsecondMax(array));

	}
	
	public static int findsecondMax(int[] data){
		int count = data.length;
		int maxnum = data[0];
		int secmax = Integer.MIN_VALUE;
		for(int i=1;i<count;i++){
			if(data[i]>maxnum){
				secmax = maxnum;
				maxnum = data[i];
			}
			else{
				if(data[i]>secmax)
					secmax = data[i];
			}
		}
		return secmax;
	}

}
