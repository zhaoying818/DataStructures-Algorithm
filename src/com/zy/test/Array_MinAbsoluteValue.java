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
	 * 用二分法来确定正负数的分界点
	 */
	public static int getMinAbosoluteValue(int[] a){
		if(a==null)
			return Integer.MIN_VALUE;
		int len = a.length;
		if(len<1)
			return Integer.MIN_VALUE;
		Arrays.sort(a);
		//数组中没有负数
		if(a[0]>=0)
			return a[0];
		//数组中没有正数
		if(a[len-1]<=0)
			return a[len-1];
		int mid = 0;
		int begin = 0;
		int end = len-1;
		int absMin = 0;
		//数组中即有正数又有负数
		while(true){
			mid = (begin+end)/2;
			//如果值等于0，那就是绝对值最小的数
			if(a[mid]==0)
				return 0;
			//如果值大于0，那么分界点就在左半部分
			else if(a[mid]>0){
				//在左半部分查找
				if(a[mid-1]>0)
					end = mid-1;
				else if(a[mid-1]==0)
					return 0;
				//找到正负数分界点
				else
					break;
			}
			//如果值小于0，在右半部分查找
			else{
				if(a[mid+1]<0)
				begin = mid+1;
			else if(a[mid+1]==0)
				return 0;
			//找到分界点
			else
				break;
			}	
		}
		//获取正负数分界点处绝对值的最小值
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
