package com.zy.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Array_NotAppearTimes {
	
	public static void main(String[] args){
		int a[] = {1,2,3,3,2,1,1,2,3,4,3,2,1};
		int appearOne = findOnce(a);
 		System.out.println(appearOne);
	}

	/**
	 * 找出只出现1次的数，其它数都出现了N次
	 * @param a
	 * @param appearTimes
	 * @return
	 */
	public static int findOnce(int a[]){
		int appearTimes = findOtherNumAppearTimes(a);//找出其他元素出现的次数
		int n = a.length;
		int[] bitCount = new int[Integer.SIZE];
		//计算数组中所有数组对应的二进制数各个位置上出现1的次数
		for(int i=0;i<n;i++)
			for(int j=0;j<32;j++)
				bitCount[j] += ((a[i]>>j)&1);
		//若某位上的结果不能被整出，则肯定目标数字在这一位上
		int appearOne = 0;
		for(int i=0;i<32;i++)
			if(bitCount[i]%appearTimes!=0)
				appearOne += (1<<i);
		return appearOne;
	}
	
	public static int findOtherNumAppearTimes(int[] a){
		int result = 0;
		int size = a.length;
		if(size==0)
			return Integer.MAX_VALUE;
		//记录每个元素出现的次数
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		for(int i=0;i<size;i++){
			if(m.containsKey(a[i])){
				m.put(a[i], m.get(a[i])+1);
			}
			else{
				m.put(a[i], 1);
			}
		}
		//找出出现次数最多的元素出现的次数
		int most = 0;
		Iterator iter = m.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			int key = (Integer)entry.getKey();
			int val = (Integer)entry.getValue();
			if(val>most){
				most = val;
			}
		}
		return most;
	}
	
}
