package com.zy.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Array_MostFrequentInArray {
	
	public static int findMostFrequentInArray(int[] a){
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
		//找出出现次数最多的元素
		int most = 0;
		Iterator iter = m.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			int key = (Integer)entry.getKey();
			int val = (Integer)entry.getValue();
			if(val>most){
				result = key;
				most = val;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {

		int[] arr = {1,5,4,3,4,4,4,5,4,5,6,8,9,6,6,6,4,5};
		int maxFrequentNum = findMostFrequentInArray(arr);
		System.out.println("重复次数最多的元素是: " + maxFrequentNum);
	}

}
