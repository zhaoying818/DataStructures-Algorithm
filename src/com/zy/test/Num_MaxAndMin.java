package com.zy.test;

public class Num_MaxAndMin {

	public static void main(String[] args) {

		System.out.println("max(3,5)=" + max(3,5));
		System.out.println("min(3,5)=" + min(3,5));
		System.out.println("max2(3,5)=" + max2(3,5));
		System.out.println("min2(3,5)=" + min2(3,5));
	}
	//���ܻ����
	public static int max(int a,int b){
		return (a+b+Math.abs(a-b))/2;
	}
	public static int min(int a,int b){
		return (a+b-Math.abs(a-b))/2;
	}
	
	//�������������ʱ��a��b��ֵת��Ϊ�����ͣ�
	public static long max2(long a,long b){
		return (a+b+Math.abs(a-b))/2;
	}
	public static long min2(long a,long b){
		return (a+b-Math.abs(a-b))/2;
	}

}
