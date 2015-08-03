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
	
	/**
	 * �ж�һ�����Ƿ���2��n�η�
	 * @param n: �������
	 * @return: �ǣ�����true;���򣬷���false
	 */
	public static boolean isPower(int n){
		if(n<1) return false;
		int m = n&(n-1);
		return m==0;
	}
	
//	public static void main(String[] args){
//		System.out.println("3����8(3����2��3�η�)Ϊ: " +powerN(3, 3));
//	}
	
	public static void main(String[] args){
		System.out.println("4��2��n�η�:" + isPower(4));
		System.out.println("5��2��n�η�:" + isPower(5));
	}


}
