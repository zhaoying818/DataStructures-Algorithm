package com.zy.test;

import java.util.concurrent.atomic.AtomicInteger;

public class Array_MaxDiffence {

	public static void main(String[] args) {
		int[] a = {1,4,17,3,2,9};
		System.out.println(getMaxDiff(a));
		System.out.println(getMaxDiff2(a));
		System.out.println(getMaxDiff3(a));
		System.out.println(getMaxDiff4(a));

	}
	
	/**
	 * ������
	 */
	public static int getMaxDiff(int[] a){
		if(a==null)
			return Integer.MIN_VALUE;
		int len = a.length;
		if(len<=1)
			return Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++)
				if(a[i]-a[j]>max)
					max = a[i] - a[j];
		}
		return max;
	}
	/**
	 * ���ַ�
	 */
	public static int getMaxDiff2(int[] a){
		if(a==null)
			return Integer.MIN_VALUE;
		int len = a.length;
		if(len<=1)
			return Integer.MIN_VALUE;
		AtomicInteger max = new AtomicInteger(0);
		AtomicInteger min = new AtomicInteger(0);
		return getMax(a,0,len-1,max,min);
	}
	public static int getMax(int[] a,int begin,int end,AtomicInteger max,AtomicInteger min){
		if(begin==end){
			max.set(a[begin]);
			min.set(a[begin]);
			return Integer.MIN_VALUE;
		}
		int middle = begin+(end-begin)/2;
		//����ǰ�벿�ֵ����ֵ����Сֵ
		AtomicInteger lMax = new AtomicInteger(0);
		AtomicInteger lMin = new AtomicInteger(0);
		//����ǰ�벿�ֵ�����ֵ
		int leftMax = getMax(a,begin,middle,lMax,lMin);
		//�����벿�ֵ���Сֵ�����ֵ
		AtomicInteger rMax = new AtomicInteger(0);
		AtomicInteger rMin = new AtomicInteger(0);
		//�����벿�ֵ�����ֵ
		int rightMax = getMax(a,middle+1,end,rMax,rMin);
		//
		int mixMax = lMax.get() - rMin.get();
		//����������ֵ����Сֵ
		if(lMax.get()>rMax.get())
			max.set(lMax.get());
		else
			max.set(rMax.get());
		if(lMin.get()<rMin.get())
			min.set(lMin.get());
		else
			min.set(rMin.get());
		//�����Ĳ�ֵ
		int allMax = (leftMax>rightMax)?leftMax:rightMax;
		allMax = (allMax>mixMax)?allMax:mixMax;
		return allMax;		 
	}
	
	/**
	 * ��̬�滮
	 */
	public static int getMaxDiff3(int[] a){
		if(a==null)
			return Integer.MIN_VALUE;
		int len = a.length;
		if(len<=1)
			return Integer.MIN_VALUE;
		int[] diff = new int[len];
		int[] max = new int[len];
		diff[0] = 0;
		max[0] = a[0];
		for(int i=1;i<len;i++){
			diff[i] = max(diff[i-1],max[i-1]-a[i]);
			max[i] = max(max[i-1],a[i]);
		}
		return diff[len-1];
	}
	public static int max(int m,int n){
		return (m>n)?m:n;
	}
	
	/**
	 * �Ľ��Ķ�̬�滮
	 */
	public static int getMaxDiff4(int[] a){
		if(a==null)
			return Integer.MIN_VALUE;
		int len = a.length;
		if(len<=1)
			return Integer.MIN_VALUE;
		int diff = 0;
		int max = a[0];
		for(int i=1;i<len;i++){
			diff = max(diff,max-a[i]);
			max = max(max,a[i]);
		}
		return diff;
	}

}
