package com.zy.test;

import java.util.Arrays;

public class Array_MinAbsoluteValue {

	public static void main(String[] args) {
		int[] a1 = {-5,-10,-2,7,50,15};
		int[] a2 = {4,6,2,8,27};
		int[] a3 = {-9,-3,-7,-13};
		System.out.println(getMinAbosoluteValue(a1));
		System.out.println(getMinAbosoluteValue(a2));
		System.out.println(getMinAbosoluteValue(a3));

	}
	
	/**
	 * �ö��ַ���ȷ���������ķֽ��
	 */
	public static int getMinAbosoluteValue(int[] a){
		if(a==null)
			return Integer.MIN_VALUE;
		int len = a.length;
		if(len<1)
			return Integer.MIN_VALUE;
		Arrays.sort(a);
		//������û�и���
		if(a[0]>=0)
			return a[0];
		//������û������
		if(a[len-1]<=0)
			return a[len-1];
		int mid = 0;
		int begin = 0;
		int end = len-1;
		int absMin = 0;
		//�����м����������и���
		while(true){
			mid = (begin+end)/2;
			//���ֵ����0���Ǿ��Ǿ���ֵ��С����
			if(a[mid]==0)
				return 0;
			//���ֵ����0����ô�ֽ�������벿��
			else if(a[mid]>0){
				//����벿�ֲ���
				if(a[mid-1]>0)
					end = mid-1;
				else if(a[mid-1]==0)
					return 0;
				//�ҵ��������ֽ��
				else
					break;
			}
			//���ֵС��0�����Ұ벿�ֲ���
			else{
				if(a[mid+1]<0)
				begin = mid+1;
			else if(a[mid+1]==0)
				return 0;
			//�ҵ��ֽ��
			else
				break;
			}	
		}
		//��ȡ�������ֽ�㴦����ֵ����Сֵ
		if(a[mid]>0){
			if(a[mid]<Math.abs(a[mid-1]))
				absMin = a[mid];
			else
				absMin = a[mid-1];
		}
		else{
			if(Math.abs(a[mid])<a[mid+1])
				absMin = a[mid];
			else
				absMin = a[mid-1];
		}
		return absMin;
	}

}
