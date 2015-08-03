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
	
	/**
	 * 判断一个数是否是2的n次方
	 * @param n: 输入的数
	 * @return: 是，返回true;否则，返回false
	 */
	public static boolean isPower(int n){
		if(n<1) return false;
		int m = n&(n-1);
		return m==0;
	}
	
//	public static void main(String[] args){
//		System.out.println("3乘以8(3乘以2的3次方)为: " +powerN(3, 3));
//	}
	
	public static void main(String[] args){
		System.out.println("4是2的n次方:" + isPower(4));
		System.out.println("5是2的n次方:" + isPower(5));
	}


}
