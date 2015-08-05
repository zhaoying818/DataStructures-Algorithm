package com.zy.test;


public class Array_NotDouble {

	public static void main(String[] args) {
		int a[] = {1,2,3,2,4,3,5,4,1};
		int res = findNotDouble(a);
		System.out.println(res);

	}
	/**
	 * 根据异或（^）运算的定义
	 * @param a
	 * @return
	 */
	public static int findNotDouble(int a[]){
		int n = a.length;
		int result = a[0];
		int i;
		for(i=1;i<n;i++)
			result ^= a[i];
		return result;
	}

}
