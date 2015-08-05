package com.zy.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Array_NotAppearTimes {
	
	public static void main(String[] args){
		int a[] = {1,2,3,3,2,1,1,2,3,4,3,2,1};
		int appearOne = findOnce(a, 4);
 		System.out.println(appearOne);
	}

	/**
	 * �ҳ�ֻ����1�ε�������������������N��
	 * @param a
	 * @param appearTimes
	 * @return
	 */
	public static int findOnce(int a[],int appearTimes){
		
		int n = a.length;
		int[] bitCount = new int[Integer.SIZE];
		//�������������������Ӧ�Ķ�����������λ���ϳ���1�Ĵ���
		for(int i=0;i<n;i++)
			for(int j=0;j<32;j++)
				bitCount[j] += ((a[i]>>j)&1);
		//��ĳλ�ϵĽ�����ܱ���������϶�Ŀ����������һλ��
		int appearOne = 0;
		for(int i=0;i<32;i++)
			if(bitCount[i]%appearTimes!=0)
				appearOne += (1<<i);
		return appearOne;
	}
	
	
}
