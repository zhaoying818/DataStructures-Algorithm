package com.zy.test;

public class OperationOfBit {
	
	/**
	 * 计算m*(2^n)
	 */
	public static int powerN(int m, int n){
		for(int i=0;i<n;i++)
			m = m<<1;
		return m;
	}
	
	
	
	public static void main(String[] args){
		System.out.println("3乘以8(3乘以2的3次方)为: " +powerN(3, 3));
	}

}
