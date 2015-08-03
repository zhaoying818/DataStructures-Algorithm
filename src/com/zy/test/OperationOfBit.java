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
	
	/**
	 * 求2进制数中1的个数
	 */
	public static int countOne(int n){
		int count = 0;//用来计数
		while(n>0){
			if(n!=0){//判断最后一位是否为1
				n = n&(n-1);
				count++;
			}	
		}
		return count;		
	}
	
//	public static void main(String[] args){
//		System.out.println("3乘以8(3乘以2的3次方)为: " +powerN(3, 3));
//	}
	
//	public static void main(String[] args){
//		System.out.println("4是2的n次方:" + isPower(4));
//		System.out.println("5是2的n次方:" + isPower(5));
//	}
	
	public static void main(String[] args){
		System.out.println("7中1的个数:" + countOne(7));
		System.out.println("8中1的个数:" + countOne(8));
	}


}
