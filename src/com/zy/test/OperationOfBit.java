package com.zy.test;

public class OperationOfBit {
	
	/**
	 * ����m*(2^n)
	 */
	public static int powerN(int m, int n){
		for(int i=0;i<n;i++)
			m = m<<1;
		return m;
	}
	
	
	
	public static void main(String[] args){
		System.out.println("3����8(3����2��3�η�)Ϊ: " +powerN(3, 3));
	}

}
